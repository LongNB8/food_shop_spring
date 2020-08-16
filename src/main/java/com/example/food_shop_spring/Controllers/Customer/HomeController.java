package com.example.food_shop_spring.Controllers.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"home", ""})
public class HomeController {
    @GetMapping
    public String index(){
        return "home.index";
    }
}
