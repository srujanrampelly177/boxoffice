package com.example.demo.exception;

import org.springframework.stereotype.Controller;

public class ProductNotFoundException extends RuntimeException 
{
	public ProductNotFoundException(String string) 
	{
		super(string);
	}

}
