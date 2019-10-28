package com.lambdaschool.crudyrestaurent;

import com.lambdaschool.crudyrestaurent.Models.Menu;
import com.lambdaschool.crudyrestaurent.Models.Restaurant;
import com.lambdaschool.crudyrestaurent.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component // away we know spring is managing it
public class SeedData implements CommandLineRunner {
    // command liner runs before spring boot take over

@Autowired // calling the service automatically
    RestaurantService rstService;

@Override
    public void run(String[] args) throws Exception {

    /////// restaurant 1
    String rest1Name = "Apple Cafe";
    Restaurant r1 = new Restaurant(rest1Name,
            "123 least  street",
            "City",
            "PR" ,
            "555-555-555");

    r1.getMenus().add(new Menu("Mac & cheese", 5.90, r1));
    r1.getMenus().add(new Menu("veggies  & fruits ", 4.90, r1));
    r1.getMenus().add(new Menu("pasta  & pizza ", 7.90, r1));
    r1.getMenus().add(new Menu("cake  & biscuit ", 9.90, r1));
    r1.getMenus().add(new Menu("buttermilk  & milk", 10.90, r1));

   rstService.save(r1);


   //////////////////////////// restaurant 2

    String rest2Name = "Apple2 Cafe";
    Restaurant r2 = new Restaurant(rest2Name,
            "34 least  street2",
            "City2",
            "PR2" ,
            "555-555-555");

    r2.getMenus().add(new Menu("Mac2 & cheese2", 5.90, r2));
    r2.getMenus().add(new Menu("veggies2  & fruits2 ", 4.90, r2));
    r2.getMenus().add(new Menu("pasta2  & pizza2", 7.90, r2));
    r2.getMenus().add(new Menu("cake2  & biscuit2", 9.90, r2));
    r2.getMenus().add(new Menu("buttermilk2  & milk2", 10.90, r2));

     rstService.save(r2);

    //////////////////////////// restaurant 3

    String rest3Name = "Apple3 Cafe";
    Restaurant r3 = new Restaurant(rest3Name,
            "34 least  street3",
            "City3",
            "PR3" ,
            "555-555-555");

    r3.getMenus().add(new Menu("Mac3 & cheese3", 5.90, r3));
    r3.getMenus().add(new Menu("veggies3 & fruits3", 4.90, r3));
    r3.getMenus().add(new Menu("pasta3  & pizza3", 7.90, r3));
    r3.getMenus().add(new Menu("cake3  & biscuit3", 9.90, r3));
    r3.getMenus().add(new Menu("buttermilk3  & milk3", 10.90, r3));

    rstService.save(r3);


    List<Restaurant> restaurantList = new ArrayList<>();
      restaurantList = rstService.findAll();

    System.out.println("******* data seed ********** \n");
    for (Restaurant rst : restaurantList) {
        System.out.println(rst);
    }
    System.out.println("******* data seed ********** \n");


}
}
