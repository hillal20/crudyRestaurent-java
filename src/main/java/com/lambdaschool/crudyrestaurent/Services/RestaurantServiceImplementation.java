package com.lambdaschool.crudyrestaurent.Services;

import com.lambdaschool.crudyrestaurent.Models.Menu;
import com.lambdaschool.crudyrestaurent.Models.Restaurant;
import com.lambdaschool.crudyrestaurent.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Transactional // since we are using a transactional save-method, it is wise to make the whole class transactional
@Service(value = "rstService") // this service  name will be called from the controller
public class RestaurantServiceImplementation implements RestaurantService {
    @Autowired // connecting the service to the repository;
    private RestaurantRepository restaurantRepository;



    //////////////////////// findAll
    @Override
    public List<Restaurant> findAll() {
       // we create iterable  to receive all the restaurants in db
        Iterable<Restaurant> restaurantsIterable;
        // because find all return an iterable
       restaurantsIterable =  restaurantRepository.findAll();
        // we create an arrayList to save the data
        List <Restaurant> restaurantsArrayList = new ArrayList();
         restaurantsIterable.forEach(e -> restaurantsArrayList.add(e));
        // or
       // restaurantsIterable.iterator().forEachRemaining(restaurantsArrayList ::add);
        return restaurantsArrayList;
    }



    ////////////////////////////////// find by id
    @Override
    public Restaurant findById(long id) {
        // findById return an Optional
      Optional<Restaurant> result  =  restaurantRepository.findById(id );
      Restaurant restaurant = result.get();
       // return restaurant;
      // or
       return  restaurantRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(" ==> id: "+ id +" not found "));

    }
    ////////////////////////////////// save
    @Transactional // telling spring if anything fails , stop saving
    @Override
    public Restaurant save(Restaurant restaurantToSave) {
        //creating empty restaurant object
        Restaurant newRestaurant = new Restaurant();

        /// filling the new  object with the data except the id from the restaurant had  been sent
        newRestaurant.setName(restaurantToSave.getName());
        newRestaurant.setAddress(restaurantToSave.getAddress()) ;
        newRestaurant.setState(restaurantToSave.getState());
        newRestaurant.setPhoneNumber(restaurantToSave.getPhoneNumber());
        newRestaurant.setCity(restaurantToSave.getCity());
        //// we re-assign menus-array one by one as well

        System.out.println("newRestaurant =>" + newRestaurant);

        for( Menu m : restaurantToSave.getMenus()){
               newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
        }
        return  restaurantRepository.save(newRestaurant);
    }
    ////////////////////////////////// update
    @Override
    public Restaurant update(Restaurant restaurantToUpdate, long id) {
        restaurantRepository.save(restaurantToUpdate);
        return null;
    }

    ////////////////////////////////// delete
    @Override
    public void delete(long id) {
        restaurantRepository.deleteById(id);

    }
}
