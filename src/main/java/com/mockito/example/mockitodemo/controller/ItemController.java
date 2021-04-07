package com.mockito.example.mockitodemo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.example.mockitodemo.business.CheckService;
import com.mockito.example.mockitodemo.business.ItemBusinessService;
import com.mockito.example.mockitodemo.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService itemBusinessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		CheckService ch = new CheckService();
		ch.someMethod();
		List<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		return new Item(1,"Book",2,100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return itemBusinessService.getItemFromBusinessService();
	}
	
	@GetMapping("/items-from-database")
	public List<Item> itemsFromDatabase(){
		return itemBusinessService.retrieveAllItems();
	}
}
