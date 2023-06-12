package com.example.Order.Management.service;

import org.springframework.stereotype.Service;


import com.example.Order.Management.model.Fooditems;

@Service
public interface FooditemsService {


	Fooditems addFooditem(Fooditems food);
	Fooditems getFooditem(long fooditemId);
	Fooditems deleteFooditem(long fooditemId);
	
	
}
