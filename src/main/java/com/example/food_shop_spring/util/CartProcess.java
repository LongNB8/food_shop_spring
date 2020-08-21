package com.example.food_shop_spring.util;

import com.example.food_shop_spring.Models.Item;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CartProcess {

    public double setSessionCart(HttpSession session){
        double total = 0;
        if (session.getAttribute("cart") != null){
            List<Item> list = (List<Item>) session.getAttribute("cart");
            for (Item item : list){
                total += item.getQuantity()* item.getProduct().getPrice();
            }
        }
        return total;

    }

    public int CountItem(HttpSession session){
        int count = 0;
        if (session.getAttribute("cart") != null){
            List<Item> list = (List<Item>) session.getAttribute("cart");
           count = list.size();
        }
        return count;

    }

    public void setTotalAndCountItem(ModelMap modelMap, HttpSession session){
        modelMap.addAttribute("total", setSessionCart(session));
       int total = CountItem(session);
        modelMap.addAttribute("countItem", total);
    }
}
