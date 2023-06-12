package com.example.Restaurant.Search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Restaurant.Search.model.Foodmenu;
import com.example.Restaurant.Search.service.FoodmenuService;

@RestController
@RequestMapping("/restaurant")
public class FoodmenuController {

	@Autowired
	private FoodmenuService foodmenuService;
	
	
	@PostMapping("/addFoodmenu")
	public ResponseEntity<Foodmenu> addfoodmenu(@RequestBody Foodmenu foodmenu)
	{
		Foodmenu food=foodmenuService.addMenu(foodmenu);
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	
	@PutMapping("/foodmenu/{foodmenuid}")
	public ResponseEntity<Foodmenu> editFoodmenu(@PathVariable long foodmenuid,@RequestBody Foodmenu foodmenu)
	{
		Foodmenu food=foodmenuService.editMenu(foodmenuid, foodmenu);
		return new ResponseEntity<>(food,HttpStatus.OK);
		
	}
	
	 @DeleteMapping("/foodmenu/{foodmenuid}/remove")
	 public ResponseEntity<Foodmenu> deleteFoodmenu(@PathVariable long foodmenuid){
		 
		 Foodmenu food=foodmenuService.deleteMenu(foodmenuid);
		 return new ResponseEntity<>(food,HttpStatus.OK);
		 
	 }
	 
	
}
