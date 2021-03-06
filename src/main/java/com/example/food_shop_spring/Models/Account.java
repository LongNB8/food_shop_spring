package com.example.food_shop_spring.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String adress;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="role_id",referencedColumnName="id")
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Blog> blogs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Comment> comments = new ArrayList<>();



}
