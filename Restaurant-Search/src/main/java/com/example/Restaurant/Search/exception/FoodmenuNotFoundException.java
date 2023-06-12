package com.example.Restaurant.Search.exception;

import java.text.MessageFormat;

public class FoodmenuNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FoodmenuNotFoundException(final Long foodmenuid){
	        super(MessageFormat.format("Could not find Menu with id: {0}", foodmenuid));
	    }


}
