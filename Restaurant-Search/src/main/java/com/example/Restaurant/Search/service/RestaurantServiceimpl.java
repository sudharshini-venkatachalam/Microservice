package com.example.Restaurant.Search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Restaurant.Search.exception.RestaurantNotFoundException;
import com.example.Restaurant.Search.model.Foodmenu;
import com.example.Restaurant.Search.model.Restaurant;
import com.example.Restaurant.Search.repository.RestaurantRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantServiceimpl implements RestaurantService{
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FoodmenuService foodmenuService;
	
	

	@Override
	public List<Restaurant> getRestaurantBydisatnce(double distance) {
		return restaurantRepository.findByDistance(distance);
	}

	@Override
	public List<Restaurant> getRestaurantByLocation(String location) {
		return restaurantRepository.findByLocation(location);
	}

	@Override
	public List<Restaurant> getRestaurantByCuisine(String cuisine) {
		return restaurantRepository.findByCuisine(cuisine);
	}

	@Override
	public List<Restaurant> getRestaurantByBudget(double budget) {
		return restaurantRepository.findByBudget(budget);
	}

	@Override
	public Restaurant getRestaurantByrestaurantname(String restaurantname) {
		return restaurantRepository.findByrestaurantname(restaurantname);
	}

	@Override
	public List<Restaurant> getAll() {
		return  restaurantRepository.findAll();
	}

	@Override
	public Restaurant Save(Restaurant restaurant) {
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(long restaurantId) {
		
		return restaurantRepository.findById(restaurantId).orElseThrow(()->new RestaurantNotFoundException(restaurantId));
	}
	
	@Transactional
	public Restaurant editRestaurant(long restaurantId,Restaurant restaurant)
	{
		
		Restaurant r1=getRestaurantById(restaurantId);
		r1.setBudget(restaurant.getBudget());
		r1.setCuisine(restaurant.getCuisine());
		r1.setDistance(restaurant.getDistance());
		r1.setLocation(restaurant.getLocation());
		r1.setRestaurantname(restaurant.getRestaurantname());
		return r1; 
		
		
	}
	
	@Transactional
	public Restaurant addFoodmenuToRestaurant(long restaurantId,long foodmenuid ) {
		
		Restaurant restaurant=getRestaurantById(restaurantId);
		Foodmenu food= foodmenuService.getMenu(foodmenuid);
		restaurant.addFoodmenu(food);
		return restaurant;
		
	}


	@Transactional
    public Restaurant removeMenuFromRestaurant(long restaurantId, long foodmenuid){
        Restaurant restaurant= getRestaurantById(restaurantId);
        Foodmenu menu=foodmenuService.deleteMenu(foodmenuid);
        restaurant.removeFoodmenu(menu);
        return restaurant;
    }

	@Override
	public Restaurant deleteRestaurant(long restaurantId) {
		Restaurant restaurant=getRestaurantById(restaurantId);
	     restaurantRepository.delete(restaurant);
		return restaurant;
	}




	
}
