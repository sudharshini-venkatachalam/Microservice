package com.example.Order.Management.exception;

import java.text.MessageFormat;

public class FooditemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FooditemNotFoundException(final Long id){
        super(MessageFormat.format("Could not find Fooditem with id: {0}", id));
    }

}
