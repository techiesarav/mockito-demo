package com.mockito.example.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mockito.example.mockitodemo.business.SampleBusinessImpl;

@SpringBootTest
class MockitoDemoApplicationJunitTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void calculateSum_Basic() {
		SampleBusinessImpl s1 = new SampleBusinessImpl();
		int[] data = new int[]{1,2,3}; 
		int result=s1.calculateSum(data);
		assertEquals(6, result);
	}

}
