package com.example.Restaurant.Search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurant.Search.exception.FoodmenuNotFoundException;
import com.example.Restaurant.Search.model.Foodmenu;
import com.example.Restaurant.Search.repository.FoodmenuRepository;

@Service
public class FoodmenuServiceimpl implements FoodmenuService{
	@Autowired
	private FoodmenuRepository foodmenuRepository;
	
	@Override
	public Foodmenu addMenu(Foodmenu food) {
		
		return foodmenuRepository.save(food);
	}

	@Override
	public Foodmenu getMenu(long foodmenuid) {
		
		return foodmenuRepository.findById(foodmenuid).orElseThrow(()->new FoodmenuNotFoundException(foodmenuid));
	}

	@Override
	public Foodmenu deleteMenu(long foodmenuid) {
		
		Foodmenu food=getMenu(foodmenuid);
		foodmenuRepository.delete(food);
		return food;
	}

	@Override
	public Foodmenu editMenu(long foodmenuid, Foodmenu food) {
	Foodmenu foodmenu=getMenu(foodmenuid);
	foodmenu.setFoodName(food.getFoodName());
	foodmenu.setFoodPrice(food.getFoodPrice());
	foodmenu.setFoodImage(food.getFoodImage());
		return foodmenu;
	}
	
	
	
}
