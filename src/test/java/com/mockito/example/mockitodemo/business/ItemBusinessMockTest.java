package com.mockito.example.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mockito.example.mockitodemo.data.ItemRepository;
import com.mockito.example.mockitodemo.model.Item;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessMockTest {

	@InjectMocks
	ItemBusinessService itemBusinessService;
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void item_business_test() {
		when(itemRepository.findAll())
		.thenReturn(Arrays.asList(new Item(1,"Book",400,2),
				new Item(2,"Table",300,2)));
		List<Item> itemList=itemBusinessService.retrieveAllItems();
		assertEquals(800, itemList.get(0).getValue());
	}
}
