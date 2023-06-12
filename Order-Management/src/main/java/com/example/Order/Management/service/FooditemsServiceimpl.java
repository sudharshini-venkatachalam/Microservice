package com.example.Order.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Order.Management.exception.FooditemNotFoundException;

import com.example.Order.Management.repository.FooditemsRepository;
import com.example.Order.Management.model.Fooditems;

@Service
public class FooditemsServiceimpl implements FooditemsService{

	
	@Autowired
	private FooditemsRepository fooditemsRepository;
	
	
	@Override
	public Fooditems addFooditem(Fooditems food) {
		
		return fooditemsRepository.save(food);
	}

	@Override
	public Fooditems getFooditem(long fooditemId) {
	
		return fooditemsRepository.findById(fooditemId).orElseThrow(()->new FooditemNotFoundException(fooditemId));
	}

	@Override
	public Fooditems deleteFooditem(long fooditemId) {
		Fooditems food= getFooditem(fooditemId);
		fooditemsRepository.delete(food);
		return food;
	}


	

}
