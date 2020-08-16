package com.example.food_shop_spring.Controllers.Admin;

import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String list(ModelMap modelMap){
        modelMap.addAttribute("category", categoryService.findByParentCategory());

        return "admin.category.index";
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap){
        Category category = new Category();
        category.setStatus(true);
        modelMap.addAttribute("category", category);
        return "admin.category.add";
    }

    @PostMapping("/add-process")
    public String add(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")int id, ModelMap modelMap){
        modelMap.addAttribute("category", categoryService.findById(id).get());
        return "admin.category.edit";

    }

    @PostMapping("/edit-process")
    public String edit(@ModelAttribute("category")Category category){
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        categoryService.deleteById(id);
        return "redirect:/admin/category";

    }

    @GetMapping("/subcategories/{id}")
    public  String listSub(@PathVariable("id")int id,  ModelMap modelMap){
        modelMap.addAttribute("category", categoryService.findById(id).get());

        return "admin.category.subcategories";
    }

    @GetMapping("/addsubcategory/{id}")
    public String addSub(@PathVariable("id") int id, ModelMap modelMap){
        Category category = new Category();
        category.setCategory(categoryService.findById(id).get());
        modelMap.addAttribute("category", category);
        return "admin.category.addsubcategory";
    }

    @PostMapping("/addsubcategory")
    public String addSub(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/admin/category/subcategories/" + category.getCategory().getId();
    }

    @GetMapping("subcategory/delete/{id}")
    public  String deleteSub(@PathVariable("id") int id){
        Category category = categoryService.findById(id).get();
        categoryService.deleteById(id);
        return "redirect:/admin/category/subcategories/" + category.getCategory().getId() ;

    }

    @GetMapping("subcategory/edit/{id}")
    public String editSub(@PathVariable("id") int id, ModelMap modelMap){
       modelMap.addAttribute("category", categoryService.findById(id));
       return "admin.category.editsubcategory";
    }

    @PostMapping("/editsubcategory")
    public String editSub(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/admin/category/subcategories/" + category.getCategory().getId();
    }

}
