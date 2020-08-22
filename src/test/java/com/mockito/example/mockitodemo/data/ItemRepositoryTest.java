package com.mockito.example.mockitodemo.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mockito.example.mockitodemo.model.Item;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void find_all_test() {
		List<Item> items=itemRepository.findAll();
		assertEquals(2, items.size());
	}
}
