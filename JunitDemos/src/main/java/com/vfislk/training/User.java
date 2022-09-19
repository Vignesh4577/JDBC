package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class User {

	public String greet(String username) {
		
		return "Have a Greatday"+username;
	}
	public List<String> showFruit() {
		
		List<String> fruits = Arrays.asList("Mango","Apple","chiku");
		
		return fruits;
		
	}
	
}
