package com.example.Order.Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Foodmenu {
	private long foodmenuid;
	private String foodName;
	 private double foodPrice;
	private String foodImage;
}
