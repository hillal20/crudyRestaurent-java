package com.lambdaschool.crudyrestaurent.Services;

import com.lambdaschool.crudyrestaurent.Models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RestaurantService{


    List<Restaurant> findAll();
    Restaurant findById(long id );
     Restaurant save(Restaurant restaurantToSave );
    Restaurant update (Restaurant restaurantToUpdate, long id );
    void delete(long id );
}
