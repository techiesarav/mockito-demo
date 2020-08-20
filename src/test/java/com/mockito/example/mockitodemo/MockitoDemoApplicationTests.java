package com.mockito.example.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.mockito.example.mockitodemo.business.SampleBusinessImpl;
import com.mockito.example.mockitodemo.service.SampleDataService;

@SpringBootTest
public class MockitoDemoApplicationTests {

	@InjectMocks
	SampleBusinessImpl s1;
	
	@Mock
	SampleDataService sampleMockDataService;
	
	@Test
	public void calculateSumUsingMockito() {
		when(sampleMockDataService.retreiveSampleData())
		.thenReturn(new int[] {1,2,3});
		assertEquals(6, s1.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateEmptySumUsingMockito() {
		when(sampleMockDataService.retreiveSampleData())
		.thenReturn(new int[] {});
		assertEquals(0, s1.calculateSumUsingDataService());
	}
}
