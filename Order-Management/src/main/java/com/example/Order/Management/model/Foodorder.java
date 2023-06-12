package com.example.Order.Management.model;

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
@Table(name="foodorder")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Foodorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String restaurantName;
	private double totalPrice;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "or_Id",referencedColumnName="id")
	private List<Fooditems> fooditems= new ArrayList<>();



public void addFooditem(Fooditems food)
{
	fooditems.add(food);
}

public void removeFooditem(Fooditems food)
{
	fooditems.remove(food);
}


}
