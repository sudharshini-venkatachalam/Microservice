package com.example.Order.Management.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class Restaurant {
	
	private long restaurantId;
	
	
	private String location;
	private double distance;
	private String cuisine;
	private double  budget;
	private String restaurantname;
	private List<Foodmenu> foodmenu=new ArrayList<>();

	

	


	
	

}
