package com.mockito.example.mockitodemo.business;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configurable(autowire=Autowire.BY_TYPE)
public class CheckService {
	
	@Autowired
	ObjectMapper objectMapper;

	public void someMethod() {
		ObjectMapper ob = objectMapper;
		System.out.println("check");
	}
}
