package com.mockito.example.mockitodemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void message_basic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				                        .get("/hello-world")
				                        .accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc
				.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().string("Helloworld"))
				.andReturn();
		//Verify Content
//		assertEquals("Helloworld",result.getResponse().getContentAsString());
		
	}
}
