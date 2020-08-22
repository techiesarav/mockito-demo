package com.mockito.example.mockitodemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mockito.example.mockitodemo.business.ItemBusinessService;
import com.mockito.example.mockitodemo.data.ItemRepository;
import com.mockito.example.mockitodemo.model.Item;

@WebMvcTest
public class ItemControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ItemBusinessService itemBusinessService;
	
	@Test
	public void dummy_item() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
//				.andExpect(content()
//						.json("{\"id\":1,\"name\":\"Book\",\"quantity\":2,\"price\":100}"))
		       .andReturn();
		String expectedStr = "{\"id\":1,\"name\":\"Book\",\"quantity\":2,\"price\":100}";
		JSONAssert.assertEquals(expectedStr, result.getResponse().getContentAsString()
				, true);
	}
	
	@Test
	public void get_item_from_business_service() throws Exception {

		when(itemBusinessService.getItemFromBusinessService())
		.thenReturn(new Item(1,"Book",2,100));
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
		       .andReturn();
		
		String expectedStr = "{\"id\":1,\"name\":\"Book\",\"quantity\":2,\"price\":100}";
		JSONAssert.assertEquals(expectedStr, result.getResponse().getContentAsString()
				, true);
	}
	
	@Test
	public void get_items_from_database() throws Exception {
		when(itemBusinessService.retrieveAllItems())
		.thenReturn(Arrays.asList(new Item(1,"Book",400,2),
				new Item(2,"Table",300,2)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
		       .andReturn();
		
		String expectedStr = "[{\"id\":1,\"name\":\"Book\",\"quantity\":400,\"price\":2}"
				+ ",{\"id\":2,\"name\":\"Table\",\"quantity\":300,\"price\":2}]";
		JSONAssert.assertEquals(expectedStr, result.getResponse().getContentAsString()
				, false);
	}
	
	@Test
	public void test_for_business_layer() throws Exception {
		when(itemBusinessService.retrieveAllItems())
		.thenReturn(Arrays.asList(new Item(1,"Book",400,2),
				new Item(2,"Table",300,2)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
		       .andReturn();
		
		String expectedStr = "[{\"id\":1,\"name\":\"Book\",\"quantity\":400,\"price\":2}"
				+ ",{\"id\":2,\"name\":\"Table\",\"quantity\":300,\"price\":2}]";
		JSONAssert.assertEquals(expectedStr, result.getResponse().getContentAsString()
				, false);
	
	}
}
