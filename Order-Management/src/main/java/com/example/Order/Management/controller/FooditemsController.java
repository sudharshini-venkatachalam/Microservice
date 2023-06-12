package com.example.Order.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Order.Management.service.FooditemsService;
import com.example.Order.Management.model.Fooditems;


@RestController
@RequestMapping("/order")
public class FooditemsController {

	@Autowired
	private FooditemsService fooditemsService;
	
	
	
	@PostMapping("/addFooditems")
	public ResponseEntity<Fooditems> addfoodmenu(@RequestBody Fooditems fooditems)
	{
		Fooditems food=fooditemsService.addFooditem(fooditems);
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	
	
}
