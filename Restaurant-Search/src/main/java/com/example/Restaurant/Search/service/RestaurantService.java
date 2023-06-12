package com.example.Restaurant.Search.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.Restaurant.Search.model.Restaurant;

@Service
public interface RestaurantService {
	List<Restaurant> getRestaurantBydisatnce(double distance);

	List<Restaurant> getRestaurantByLocation(String location);

	List<Restaurant> getRestaurantByCuisine(String cuisine);

	List<Restaurant> getRestaurantByBudget(double budget);
	Restaurant getRestaurantByrestaurantname(String restaurantname);

	List<Restaurant> getAll();

	Restaurant Save(Restaurant restaurant);
	 Restaurant getRestaurantById(long restaurantId);
	 Restaurant editRestaurant(long restaurantId,Restaurant restaurant);
	 Restaurant addFoodmenuToRestaurant(long restaurantId,long foodmenuid );
	 Restaurant removeMenuFromRestaurant(long restaurantId, long foodmenuid);
	 Restaurant deleteRestaurant(long restaurantId );
}
