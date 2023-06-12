package com.example.Restaurant.Search.service;

import org.springframework.stereotype.Service;

import com.example.Restaurant.Search.model.Foodmenu;

@Service
public interface FoodmenuService {

	
	Foodmenu addMenu(Foodmenu food);
	Foodmenu getMenu(long foodmenuid);
	Foodmenu deleteMenu(long foodmenuid);
	Foodmenu editMenu(long foodmenuid,Foodmenu food);
}
