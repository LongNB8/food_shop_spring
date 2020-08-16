package com.example.food_shop_spring.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "photo_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoPr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private boolean status;
    private boolean main;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="product_id")
    private Product product;


}
