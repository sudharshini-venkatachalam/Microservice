package com.example.Order.Management.controller;



import java.util.List;

import com.example.Order.Management.model.Foodmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Order.Management.model.Foodorder;
import com.example.Order.Management.model.Restaurant;
import com.example.Order.Management.responsetemplateVO.ResponseTemplateVO;
import com.example.Order.Management.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Controller
@RequestMapping("/order")
public class Ordercontroller {

	@Autowired
	private OrderService orderService;
	
	 private static final String ORDER_SERVICE="order_service";
	
	@GetMapping("/allRestaurant")
public String viewRestaurants(Model model)
	{
		List<Restaurant> r1=orderService.getAllRestaurant();
		model.addAttribute("r1",r1);
		return "index";
	}
	 
	 @GetMapping("/{restaurantName}")
	 public String viewAllitems(@PathVariable String restaurantName,Model model)
	 {
		 List<Foodmenu> f1=orderService.getRestaurantWithItems(restaurantName);
		 model.addAttribute("f1",f1);
		 return "allitems";
	 }
	 
	 
	
	@PostMapping("/placeorder")
	public ResponseEntity<Foodorder> createOrder( Foodorder foodorder)
	{
		Foodorder food=orderService.save(foodorder);
	return new ResponseEntity<>(food,HttpStatus.OK);
	}




	@GetMapping("/vieworderwithRestaurant/{id}")
	@CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "orderserviceFallback")
	public ResponseTemplateVO  getOrderWithRestaurant(@PathVariable long id)
	{
		ResponseTemplateVO vo=orderService.getorderWithRestaurant(id);
		return vo;
	}
	
	
	public ResponseTemplateVO  orderserviceFallback(long id,Exception e)
	{
		ResponseTemplateVO  vo=new ResponseTemplateVO();
		Foodorder food=orderService.getfoodorderById(id);
		Restaurant r=new Restaurant();
		r.setRestaurantId(1);
		r.setBudget(500);
		r.setCuisine("chinese");
		r.setDistance(20);
		r.setLocation("erode");
		r.setRestaurantname("Meenakshi mess");
		vo.setFoodorder(food);
		vo.setRestaurant(r);
		return vo;
				
	}

	
	@PutMapping("/updateorder/{id}")
	public ResponseEntity<Foodorder> updateOrder(@PathVariable long id,@RequestBody Foodorder order) {
		
		Foodorder food=orderService.update(id, order);
		
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	

	
	@DeleteMapping("/cancelorder/{id}")
	public ResponseEntity<Foodorder> deleteOrder(@PathVariable long id) {
		
		Foodorder food= orderService.deleteOrder(id);
		return new ResponseEntity<>(food,HttpStatus.OK);
		
	}
	
	@PostMapping("/{id}/fooditem/{fooditemId}/add")
	public ResponseEntity<Foodorder> addfooditemToOrder(@PathVariable long id,@PathVariable long fooditemId)
	{
		Foodorder food=orderService.addFoodiemsToFoodorder(id, fooditemId);
		food.setTotalPrice(food.getFooditems().stream().mapToDouble(e->e.getFoodPrice()*e.getQuantity()).sum());
		orderService.save(food);
	    return new ResponseEntity<>(food,HttpStatus.OK);
	}
	@DeleteMapping("/{id}/fooditem/{fooditemId}/remove")
	public ResponseEntity<Foodorder> removefooditemToOrder(@PathVariable long id,@PathVariable long fooditemId)
	{
		Foodorder food=orderService.removeFooditemsFromFoodorder(id, fooditemId);
		food.setTotalPrice(food.getFooditems().stream().mapToDouble(e->e.getFoodPrice()*e.getQuantity()).sum());
		orderService.save(food);
	    return new ResponseEntity<>(food,HttpStatus.OK);
	}
}
