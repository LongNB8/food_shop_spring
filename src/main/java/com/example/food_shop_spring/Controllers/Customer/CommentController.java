package com.example.food_shop_spring.Controllers.Customer;


import com.example.food_shop_spring.Models.Comment;
import com.example.food_shop_spring.Services.AccountService;
import com.example.food_shop_spring.Services.BlogService;
import com.example.food_shop_spring.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private AccountService accountService;


    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();


    @PostMapping("/add/{blog_id}")
    public String addComment(@PathVariable("blog_id") int id,
                             HttpServletRequest request,
                             @ModelAttribute("comment")Comment comment,
                             HttpSession session){


        comment.setBlog(blogService.findById(id).get());
        comment.setAccount(accountService.findByUsername((String) session.getAttribute("username")));
        comment.setCreate_at(dateFormat.format(date));
        commentService.save(comment);

        return "redirect:"+request.getHeader("Referer");

    }

    @PostMapping("/add/{blog_id}/{comment_id}")
    public String addSubComment(@PathVariable("blog_id") int blog_id,
                                @PathVariable("comment_id") int comment_id,
                                @ModelAttribute("subcomment") Comment comment,
                                HttpSession session,
                                HttpServletRequest request){

        comment.setBlog(blogService.findById(blog_id).get());
        comment.setComment(commentService.findById(comment_id).get());
        comment.setAccount(accountService.findByUsername((String) session.getAttribute("username")));
        comment.setCreate_at(dateFormat.format(date));

        commentService.save(comment);

        return "redirect:"+request.getHeader("Referer");

    }
}
