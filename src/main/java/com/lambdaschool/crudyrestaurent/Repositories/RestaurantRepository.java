package com.lambdaschool.crudyrestaurent.Repositories;

import com.lambdaschool.crudyrestaurent.Models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    // restaurant  has index of type long with capital L because it is a class

}
