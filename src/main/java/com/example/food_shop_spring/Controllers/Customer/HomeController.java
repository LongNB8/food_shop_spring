package com.example.food_shop_spring.Controllers.Customer;

import com.example.food_shop_spring.Models.Account;
import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Models.PhotoPr;
import com.example.food_shop_spring.Models.Product;
import com.example.food_shop_spring.Repositories.AccountRepository;
import com.example.food_shop_spring.Services.AccountService;
import com.example.food_shop_spring.Services.CategoryService;
import com.example.food_shop_spring.Services.PhotoProService;
import com.example.food_shop_spring.Services.ProductService;
import com.example.food_shop_spring.util.CartProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"home", ""})
public class HomeController {

    private CartProcess cartProcess = new CartProcess();

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PhotoProService photoProService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;


    @GetMapping
    public String index(ModelMap modelMap, HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap, session);
        int count = cartProcess.CountItem(session);
        modelMap.addAttribute("countItem", count);
        List<Category> category1 = categoryService.listCategoryOur1(true,3);
        modelMap.addAttribute("pho", photoProService.findById(1).get());
        modelMap.addAttribute("category", category1);
        modelMap.addAttribute("product", productService.ListNewProduct(8));
        return "home.index";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session){

        Account account = accountService.findByEmailOrUsername(username);

       if (account == null || !account.getPassword().equals(password)) {
           session.setAttribute("mess","UserName and Password not true!");

       } else {
           session.removeAttribute("mess");
           session.setAttribute("username",account.getUsername());
           session.setMaxInactiveInterval(900);
       }
       if (session.getAttribute("username") == null){
           System.out.println("ngu");
       } else {
           System.out.println(session.getAttribute("username")+"1======");
       }
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }


}
