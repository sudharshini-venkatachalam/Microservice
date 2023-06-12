package com.example.Restaurant.Search.exception;

import java.text.MessageFormat;

public class RestaurantNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public RestaurantNotFoundException(final Long restaurantId){
	        super(MessageFormat.format("Could not find Restaurant with id: {0}", restaurantId));
	    }

}
