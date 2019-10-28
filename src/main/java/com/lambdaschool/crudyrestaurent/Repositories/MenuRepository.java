package com.lambdaschool.crudyrestaurent.Repositories;

import com.lambdaschool.crudyrestaurent.Models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    // menu   has index of type long with capital L because it is a class




}
