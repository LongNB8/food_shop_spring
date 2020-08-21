package com.example.food_shop_spring.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Product product;
    private int quantity;
    private PhotoPr photo;
}
