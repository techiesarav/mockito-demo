package com.mockito.example.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mockito.example.mockitodemo.business.SampleBusinessImpl;
import com.mockito.example.mockitodemo.service.SampleDataService;

class SampleStubDataService implements SampleDataService{

	@Override
	public int[] retreiveSampleData() {
		return new int[] {1,2,3};
	}
	
}

class SampleStubEmptyDataService implements SampleDataService{

	@Override
	public int[] retreiveSampleData() {
		return new int[] {};
	}
	
}

@SpringBootTest
public class MockitoDemoStubApplicationTests {

	@Test
	public void calculateSumUsingDataService() {
		SampleBusinessImpl s1 = new SampleBusinessImpl();
		s1.setSampleDataService(new SampleStubDataService());
		int result=s1.calculateSumUsingDataService();
		assertEquals(6, result);
	}
	
	@Test
	public void calculateSumForEmptyDataService() {
		SampleBusinessImpl s1 = new SampleBusinessImpl();
		s1.setSampleDataService(new SampleStubEmptyDataService());
		int result=s1.calculateSumUsingDataService();
		assertEquals(0, result);
	}
}
