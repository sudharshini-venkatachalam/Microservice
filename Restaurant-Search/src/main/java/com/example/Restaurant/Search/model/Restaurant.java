package com.example.Restaurant.Search.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long restaurantId;
	
	
	private String location;
	private double distance;
	private String cuisine;
	private double  budget;
	private String restaurantname;
	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="restaurant_id",referencedColumnName="restaurantId")
	
	List<Foodmenu> foodmenu=new ArrayList<>();


	
	public void addFoodmenu(Foodmenu food)
	{
		foodmenu.add(food);
	}
	
	public void removeFoodmenu(Foodmenu food)
	{
		foodmenu.remove(food);
	}
	


	
	
	
	

}
