package com.example.food_shop_spring.Controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardController {
    @GetMapping
    public String index(){
        return "admin.dashboard.index";
    }
}
