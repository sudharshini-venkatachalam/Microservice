package com.example.Restaurant.Search.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="foodmenu")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Foodmenu {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long foodmenuid;
	private String foodName;
	 private double foodPrice;
	 private String foodImage;
	
	


	
	 
}
