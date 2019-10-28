package com.lambdaschool.crudyrestaurent.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // create table for us called  restaurant
@Table(name = "restaurants") // this part enforce the name of the table to restaurants
public class Restaurant {
    // ====> plz make all the fields lower case to let them work properly with all the data bases

    @Id // making this  field  as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // asking java to generate it for us
    private long restaurantid;


    @Column(unique = true,nullable = false) // columns never null and unique
    private String name;
    private String address;
    private String state;
    private String city ;
    private String phoneNumber;


    @OneToMany(mappedBy = "restaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true) //  this field is stated in the Menu fields
    //creating a field connected to menus true the field restaurant in menus table\
    private List<Menu> menus = new ArrayList<>();

    //constructor , we exclude the field menus because it is a list
    public Restaurant(String name, String address, String state, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.state = state;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }


    public Restaurant() { // any entity (table) for the data base  has to have a default constructor
    }

    // setters and getters
    public long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList menus) {
        this.menus = menus;
    }
}
