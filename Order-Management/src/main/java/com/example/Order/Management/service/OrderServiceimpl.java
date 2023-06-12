package com.example.Order.Management.service;



import com.example.Order.Management.model.Foodmenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.example.Order.Management.exception.FoodorderNotFoundException;
import com.example.Order.Management.repository.OrderRepository;
import com.example.Order.Management.responsetemplateVO.ResponseTemplateVO;
import com.example.Order.Management.model.Fooditems;
import com.example.Order.Management.model.Foodorder;
import com.example.Order.Management.model.Restaurant;

import java.util.List;
import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
public class OrderServiceimpl implements OrderService{

	
	private static final Logger logger=LoggerFactory.getLogger(OrderServiceimpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private FooditemsService fooditemsService;
	@Autowired 
	private RestTemplate restTemplate;
	
	
	
	@Override
	public Foodorder save(Foodorder order) {
		order.setTotalPrice(order.getFooditems().stream().mapToDouble(e->e.getFoodPrice()*e.getQuantity()).sum());
		return orderRepository.save(order);
	}


	
	@Override
	public Foodorder deleteOrder(long id) {
		Foodorder food =getfoodorderById(id); 
		orderRepository.delete(food);
		return food;
		
	}



	@Transactional
	@Override
	public Foodorder update(long id,Foodorder order) {
		Foodorder food =getfoodorderById(id); 
		food.setRestaurantName(order.getRestaurantName());
		food.setUserName(order.getUserName());
		food.setTotalPrice(food.getFooditems().stream().mapToDouble(e->e.getFoodPrice()*e.getQuantity()).sum());
		logger.info("Totalprice  of the order is {}:",food.getTotalPrice());
		return food;
	}



	@Override
	public Foodorder getfoodorderById(long id) {
		
		return orderRepository.findById(id).orElseThrow(() ->
        new FoodorderNotFoundException(id));
	}



	@Override
	
	public ResponseTemplateVO getorderWithRestaurant(long id) {
		
		ResponseTemplateVO vo=new ResponseTemplateVO();
	        Foodorder foodorder=orderRepository.findById(id).get();

	       Restaurant restaurant =
	                restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/restaurantname " + foodorder.getRestaurantName(),Restaurant.class);
	                       
	       vo.setFoodorder(foodorder);
	       vo.setRestaurant(restaurant);
	       

	        return vo ;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {

		ResponseEntity<List<Restaurant>> r1=  restTemplate.exchange("http://RESTAURANT-SERVICE/restaurant/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Restaurant>>() {
		} );
		List< Restaurant> r2=r1.getBody();
		return r2;


	}


	@Transactional
	@Override
	public Foodorder addFoodiemsToFoodorder(long id, long fooditemId) {
		Foodorder food=getfoodorderById(id);
		Fooditems fooditems=fooditemsService.getFooditem(fooditemId);
		food.addFooditem(fooditems);
		return food;
	}


	@Transactional
	@Override
	public Foodorder removeFooditemsFromFoodorder(long id, long fooditemId) {
		Foodorder food=getfoodorderById(id);
		Fooditems fooditems=fooditemsService.getFooditem(fooditemId);
		food.removeFooditem(fooditems);
		return food;
	}

	@Override
	public List<Foodmenu> getRestaurantWithItems(String restaurantName) {

		ResponseEntity<List<Foodmenu>> r1=  restTemplate.exchange("http://RESTAURANT-SERVICE/restaurant/ "+restaurantName+" /menu", HttpMethod.GET, null, new ParameterizedTypeReference<List<Foodmenu>>() {
		} );
		List< Foodmenu> r2=r1.getBody();
		return r2;
	}



}
