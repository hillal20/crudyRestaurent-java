package com.lambdaschool.crudyrestaurent.Models;

import javax.persistence.*;

@Entity // tell java to this a table
@Table(name = "menus") // enforce the name
public class Menu {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private long menuid;


    @Column(unique = true, nullable = false) // the dish name has to be unique and  not null
    private String dish;


    private double price;


    /// there is lot menus related to one restaurant
    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false) // join column name restaurantid which mapped to it
    private Restaurant restaurant; // this field is the one connected from restaurant


    //// constructor
    public Menu(String dish, double price, Restaurant restaurant) {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    // default constructor


    public Menu() { // any entity (table) for the data base  has to have a default constructor
    }

    /// getters nd setters
    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
