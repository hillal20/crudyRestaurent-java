package com.lambdaschool.crudyrestaurent.Controllers;

import com.lambdaschool.crudyrestaurent.Models.Restaurant;
import com.lambdaschool.crudyrestaurent.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired // calling the service automatically by name
    private RestaurantService rstService;

    //get all restaurants
   @GetMapping(value = "/allRestaurants", produces = {"application/json"})
   public ResponseEntity<?> getAllRestaurants(){
       List<Restaurant > restaurantsList  = rstService.findAll();
       return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
   }

    // get a restaurant by id
    @GetMapping(value ="/restaurant/{id}", produces = {"application/json"})
    public ResponseEntity<?> getRestaurantById(@PathVariable long id){

       Restaurant rest = rstService.findById(id );
       return new ResponseEntity<>(rest, HttpStatus.OK);
    }


    // post a restaurant
    @PostMapping(value = "/restaurant", consumes = {"application/json"})
    public ResponseEntity<?> saveRestaurant( @Valid  @RequestBody Restaurant rst){
        // @ valid means valid
       Restaurant  restaurant  = rstService.save(rst);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    // update a restaurant
    @PutMapping(value = "/restaurant/id", consumes = {"application/json"} )
    public ResponseEntity<?> updateRestaurant( @RequestBody Restaurant newRestaurant ,  @PathVariable long id ){
       Restaurant res = rstService.update( newRestaurant, id);
       return new  ResponseEntity<>(res,HttpStatus.CREATED );
    }



    // delete a restaurant
    @DeleteMapping(value="/restaurant/{id}")
    public  ResponseEntity<?> deleteRestaurant(@PathVariable long id){
       rstService.delete(id);
      return new  ResponseEntity<>(HttpStatus.OK);
    }



}
