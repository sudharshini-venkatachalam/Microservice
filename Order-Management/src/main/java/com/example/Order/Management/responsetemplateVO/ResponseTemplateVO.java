package com.example.Order.Management.responsetemplateVO;

import com.example.Order.Management.model.Foodorder;
import com.example.Order.Management.model.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	
	private Foodorder foodorder;
	private Restaurant restaurant;

}
