package com.example.food_shop_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class FoodShopSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodShopSpringApplication.class, args);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
       // System.out.println(dateFormat.format(date));
    }

}
