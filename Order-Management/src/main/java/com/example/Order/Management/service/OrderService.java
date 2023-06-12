package com.example.Order.Management.service;

import com.example.Order.Management.model.Foodmenu;
import com.example.Order.Management.model.Restaurant;
import org.springframework.stereotype.Service;

import com.example.Order.Management.responsetemplateVO.ResponseTemplateVO;

import com.example.Order.Management.model.Foodorder;

import java.util.List;


@Service
public interface OrderService {

	Foodorder getfoodorderById(long id);
	Foodorder save(Foodorder order);
	Foodorder update(long id,Foodorder order);
	Foodorder deleteOrder(long id);
	Foodorder addFoodiemsToFoodorder(long id,long fooditemId);
	Foodorder removeFooditemsFromFoodorder(long id,long fooditemId);
	List<Foodmenu> getRestaurantWithItems(String restaurantName);
	ResponseTemplateVO getorderWithRestaurant(long id);
	List<Restaurant> getAllRestaurant();
}
