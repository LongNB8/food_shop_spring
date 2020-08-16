package com.example.food_shop_spring.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private String quantity;
    private boolean status;
    private String description;
    private double price;

    private boolean featured;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<PhotoPr> photos = new ArrayList<>();



}
