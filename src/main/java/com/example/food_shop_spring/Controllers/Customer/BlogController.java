package com.example.food_shop_spring.Controllers.Customer;

import com.example.food_shop_spring.Models.Blog;
import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Models.Comment;
import com.example.food_shop_spring.Services.*;
import com.example.food_shop_spring.util.CartProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController implements ServletContextAware {

    private ServletContext servletContext;
    private CartProcess cartProcess = new CartProcess();

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String index(ModelMap modelMap,  HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap, session);
        modelMap.addAttribute("blog", blogService.findAll());
        modelMap.addAttribute("lastestproduct", productService.ListNewProduct(3));
        List<Category> list = categoryService.findByParentCategory();
        for (Category category : list){
            category.setCategories(categoryService.listSubCategory(category.getId()));
        }

        modelMap.addAttribute("category", list);
        return "home.blog.index";
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap, HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap, session);
        modelMap.addAttribute("blog", new Blog());
        modelMap.addAttribute("categories", categoryService.findByParentCategory());
        return "home.blog.add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("blog")Blog blog,
                      @RequestParam("file") MultipartFile file,
                      HttpSession session){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        blog.setCreate_at(dateFormat.format(date));
        blog.setImage(uploadFile(file));

        if (session.getAttribute("username") != null){
            blog.setAccount(accountService.findByUsername((String) session.getAttribute("username")));
        }
        blogService.save(blog);
        return "redirect:/blog";
    }


    @GetMapping("details/{id}")
    public String details(@PathVariable("id") int id, ModelMap modelMap, HttpSession session){
        cartProcess.setTotalAndCountItem(modelMap, session);
        List<Comment> listComment = commentService.findByBlogId(id);
        modelMap.addAttribute("blog", blogService.findById(id).get());
        modelMap.addAttribute("lastestproduct", productService.ListNewProduct(3));
        modelMap.addAttribute("comment", new Comment());
        modelMap.addAttribute("subcomment", new Comment());
        List<Category> list = categoryService.findByParentCategory();
        for (Category category : list){
            category.setCategories(categoryService.listSubCategory(category.getId()));
        }
        modelMap.addAttribute("comments", listComment);
        modelMap.addAttribute("countcomment", listComment.size());
        modelMap.addAttribute("category", list);

        return "home.blog.details";
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
