package com.example.food_shop_spring.Controllers.Admin;

import com.example.food_shop_spring.Models.PhotoPr;
import com.example.food_shop_spring.Models.Product;
import com.example.food_shop_spring.Repositories.PhotoPrRepository;
import com.example.food_shop_spring.Services.CategoryService;
import com.example.food_shop_spring.Services.ProductService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.awt.print.Pageable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin/product")
public class ProductController implements ServletContextAware {
    private ServletContext servletContext;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PhotoPrRepository photoPrRepository;

    @GetMapping
    public String index(ModelMap modelMap){

        modelMap.addAttribute("products", productService.findAll1());
        return "admin.product.index";
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap){
        Product product = new Product();
        product.setStatus(true);
        product.setFeatured(true);
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("categories", categoryService.findByParentCategory());
        return "admin.product.add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        productService.deleteById(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("product", productService.findById(id).get());
        modelMap.addAttribute("categories", categoryService.findByParentCategory());
        return "admin.product.edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product")Product product){
        productService.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/photo/{id}")
    public String photoOfProduct(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("product", productService.findById(id).get());

        return "admin.photo.photo_of_product";
    }

    @GetMapping("/addphoto/{id}")
    public String addPhoto(@PathVariable("id") int id, ModelMap modelMap){
        PhotoPr photoPr = new PhotoPr();
        photoPr.setMain(true);
        photoPr.setStatus(true);
        photoPr.setProduct(productService.findById(id).get());
        modelMap.addAttribute("photo", photoPr );
        return "admin.photo.add";
    }

    @PostMapping("/addphoto")
    public String addPhoto(@ModelAttribute("photo")PhotoPr photo, @RequestParam("file")MultipartFile file){
        photo.setName(uploadFile(file));
        photoPrRepository.save(photo);
        return "redirect:/admin/product/photo/"+photo.getProduct().getId();
    }

    @GetMapping("/editPhoto/{id}")
    public String editPhoto(@PathVariable("id")int id, ModelMap modelMap){

        modelMap.addAttribute("photo", photoPrRepository.findById(id).get());
        //System.out.println(photoPrRepository.findById(id).get().getProduct().getId()+"============");
        return "admin.photo.edit";
    }

    @PostMapping("/editphoto")
    public String editPhoto(@ModelAttribute("photo")PhotoPr photo, @RequestParam("file")MultipartFile file){
        photo.setName(uploadFile(file));
        photoPrRepository.save(photo);
        //System.out.println(photo.getProduct().getId());
        return "redirect:/admin/product/photo/2";
    }


    private String uploadFile(MultipartFile file){
        try {
            byte [] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/uploads/images/"+file.getOriginalFilename()));
            Files.write(path, bytes);
            return file.getOriginalFilename();
        } catch (Exception e){
            return "no-image";
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
