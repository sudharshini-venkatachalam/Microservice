package com.example.Order.Management.exception;

import java.text.MessageFormat;

public class FoodorderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FoodorderNotFoundException(final Long id){
        super(MessageFormat.format("Could not find Foodorder with id: {0}", id));
    }

}
