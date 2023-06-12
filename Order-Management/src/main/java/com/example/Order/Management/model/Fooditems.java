package com.example.Order.Management.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fooditems")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fooditems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fooditemId;

	 private String foodName;
	 private double foodPrice;

	 private int quantity;
	

	
}
