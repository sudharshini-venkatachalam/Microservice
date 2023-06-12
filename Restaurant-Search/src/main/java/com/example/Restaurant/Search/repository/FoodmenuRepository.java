package com.example.Restaurant.Search.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Restaurant.Search.model.Foodmenu;



public interface FoodmenuRepository extends JpaRepository<Foodmenu, Long>{

}
