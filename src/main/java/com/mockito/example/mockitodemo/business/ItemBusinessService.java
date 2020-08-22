package com.mockito.example.mockitodemo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mockito.example.mockitodemo.data.ItemRepository;
import com.mockito.example.mockitodemo.model.Item;


@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item getItemFromBusinessService() {
		return new Item(1,"Book",2,100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = itemRepository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}
}
