package com.example.food_shop_spring.Controllers.Customer;

import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Models.Item;
import com.example.food_shop_spring.Models.PhotoPr;
import com.example.food_shop_spring.Models.Product;
import com.example.food_shop_spring.Services.CategoryService;
import com.example.food_shop_spring.Services.ProductService;
import com.example.food_shop_spring.util.CartProcess;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductHomeController {

    private CartProcess cartProcess = new CartProcess();

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String index(ModelMap modelMap,
                        @RequestParam(value = "page", defaultValue = "1")int page,
                        @RequestParam(value = "limit",required = false, defaultValue = "2")int limit,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        HttpSession session){
       cartProcess.setTotalAndCountItem(modelMap,session);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, limit, sortable);
        Page<Product> page1 = productService.findAllPro(pageable);
//        for (Product product : page1){
//            System.out.println(product.getName());
//        }

        //modelMap.addAttribute("product", productService.ListNewProduct(6));
        List<Product> list1 = page1.toList();

        modelMap.addAttribute("page1",list1);
        modelMap.addAttribute("lastestproduct", productService.ListNewProduct(3));
        List<Category> list = categoryService.findByParentCategory();
        for (Category category : list){
            category.setCategories(categoryService.listSubCategory(category.getId()));
        }

        modelMap.addAttribute("category", list);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("totalPage", (productService.CountPr()/limit)+1);

        return "home.product.product_of_category";
    }



    @GetMapping("/search/keyword={keyword}")
    public String search1(@PathVariable("keyword")String keyword, ModelMap modelMap, HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap,session);
        modelMap.addAttribute("product", productService.searchAll(keyword,true,6));
        modelMap.addAttribute("lastestproduct", productService.ListNewProduct(3));
        List<Category> list = categoryService.findByParentCategory();
        for (Category category : list){
            category.setCategories(categoryService.listSubCategory(category.getId()));
        }

        modelMap.addAttribute("category", list);
        return "home.product.search";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String keyword, ModelMap modelMap){
        System.out.println(keyword);
        return "redirect:/product/search/keyword=" + keyword;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") int id, ModelMap modelMap, HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap,session);
        Product product = productService.findById(id).get();
        PhotoPr photo = product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get();
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("photo", photo);
        return "home.product.details";

    }


    // =========Cart==================


    @GetMapping("/buy/{id}")
    public String buyItem(@PathVariable("id")int id, HttpSession session, ModelMap modelMap, HttpServletRequest request){
        Product product = productService.findById(id).get();
        PhotoPr photo = product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get();
        Item item = new Item();
        item.setPhoto(photo);
        item.setProduct(product);
        item.setQuantity(1);
        if (session.getAttribute("cart") == null){
            List<Item> cart = new ArrayList<>();

            cart.add(item);
            session.setAttribute("cart", cart);
        } else {

            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = exits(id, cart);
            if (index == -1){
                cart.add(item);
            } else {
                int newQuantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(newQuantity);
            }
            session.setAttribute("Cart", cart);
        }

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/cart/remove/{index}")
    public String remove(@PathVariable("index")int index, ModelMap modelMap, HttpSession session, HttpServletRequest request){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        cart.remove(index);
        session.setAttribute("cart", cart);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }


    private int exits(int id, List<Item> cart){
        for (int i = 0; i<cart.size(); i++){
            if (cart.get(i).getProduct().getId() == id){
                return i;
            }
        }
        return -1;
    }

    @PostMapping("/checkount")
    public String checkout(HttpSession session, HttpServletRequest request){

        if (session.getAttribute("username") == null){
            session.setAttribute("mess1", "You need login !");

        }
        if (session.getAttribute("username") != null && session.getAttribute("cart") != null){
            session.setAttribute("cart", null);
        }
        System.out.println(request.getHeader("Referer"));
        return "redirect:" + request.getHeader("Referer");
    }


}
