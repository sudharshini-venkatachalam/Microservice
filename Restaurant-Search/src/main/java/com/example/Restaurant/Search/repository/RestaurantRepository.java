package com.example.Restaurant.Search.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Restaurant.Search.model.Restaurant;



@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Long>{
	List<Restaurant> findByLocation(String location);

	List<Restaurant> findByCuisine(String cuisine);

	List<Restaurant> findByBudget(double budget);

	Restaurant findByrestaurantname(String restaurantname);

	List<Restaurant> findByDistance(double distance);

	
	
}
