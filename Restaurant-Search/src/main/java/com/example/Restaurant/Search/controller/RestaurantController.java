package com.example.Restaurant.Search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.Search.model.Foodmenu;
import com.example.Restaurant.Search.model.Restaurant;
import com.example.Restaurant.Search.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant)	{
		
		Restaurant restaurant1=restaurantService.Save(restaurant);
		return new ResponseEntity<>(restaurant1, HttpStatus.OK);
	}
	
	
	@GetMapping("/{restaurantId}/foodmenu")
	public ResponseEntity< List<Foodmenu> >retrieveAllmenuByrestaurantid(@PathVariable long restaurantId){
		Restaurant restaurant=restaurantService.getRestaurantById(restaurantId);
		
		return new ResponseEntity<>( restaurant.getFoodmenu(), HttpStatus.OK);
		
	}
	
	@GetMapping("/distance/{distance}")
	public ResponseEntity<List<Restaurant>> getRestaurantBydisatnce(@PathVariable double distance)
	{
		List<Restaurant> restaurant= restaurantService.getRestaurantBydisatnce(distance);

		return  new ResponseEntity<>(restaurant,HttpStatus.OK);
	}

	@GetMapping("/location/{location}")
	public ResponseEntity<List<Restaurant>> getRestaurantByLocation(@PathVariable String location)
	{
		List<Restaurant> restaurant= restaurantService.getRestaurantByLocation(location);

		return  new ResponseEntity<>(restaurant,HttpStatus.OK);
	}

	
	@GetMapping("/cuisine/{cuisine}")
	public ResponseEntity<List<Restaurant>> getRestaurantByCuisine(@PathVariable String cuisine)
	{
		List<Restaurant> restaurant= restaurantService.getRestaurantByCuisine(cuisine);

		return  new ResponseEntity<>(restaurant,HttpStatus.OK);
	}

	@GetMapping("/budget/{budget}")
	public ResponseEntity<List<Restaurant>>getRestaurantByBudget(@PathVariable double budget)
	{
		List<Restaurant> restaurant= restaurantService.getRestaurantByBudget(budget);

		return  new ResponseEntity<>(restaurant,HttpStatus.OK);
	}

	
	@GetMapping("/{restaurantname}/menu")
	public ResponseEntity<List<Foodmenu>> getRestaurantByrestaurantname(@PathVariable String restaurantname)
	{
		Restaurant restaurant= restaurantService.getRestaurantByrestaurantname(restaurantname);

		List<Foodmenu> f=restaurant.getFoodmenu();
		return  new ResponseEntity<>(f,HttpStatus.OK);
	}
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable long restaurantId){
		Restaurant restaurant=restaurantService.getRestaurantById(restaurantId);
		
		return new  ResponseEntity<>(restaurant,HttpStatus.OK);
		}
	
	@PutMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> editRestauarnt(@PathVariable long restaurantId,@RequestBody Restaurant restaurant)
	{
		Restaurant restaurant1=restaurantService.editRestaurant(restaurantId, restaurant);
		return new ResponseEntity<>(restaurant1,HttpStatus.OK);
	}

	@PostMapping("/{restaurantId}/menu/{foodmenuid}/add")
	public ResponseEntity<Restaurant> addMenuToRestaurant(@PathVariable long restaurantId,@PathVariable long foodmenuid)
	{
		Restaurant restaurant=restaurantService.addFoodmenuToRestaurant(restaurantId, foodmenuid);
		return new ResponseEntity<>(restaurant,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{restaurantId}/menu/{foodmenuid}/remove")
	public ResponseEntity<Restaurant> removeMenuFromRestaurant(@PathVariable long restaurantId,@PathVariable long foodmenuid)
	{
		
		Restaurant restaurant=restaurantService.removeMenuFromRestaurant(restaurantId, foodmenuid);
		return new ResponseEntity<>(restaurant,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable long restaurantId)
	{
		Restaurant restaurant=restaurantService.deleteRestaurant(restaurantId);
		return new ResponseEntity<>(restaurant,HttpStatus.OK);
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<Restaurant>> getallRestaurant()
	{
		List<Restaurant> restaurant=restaurantService.getAll();
		return new ResponseEntity<>(restaurant,HttpStatus.OK);

	}
}
