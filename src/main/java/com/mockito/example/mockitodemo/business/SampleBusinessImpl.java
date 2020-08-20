package com.mockito.example.mockitodemo.business;

import com.mockito.example.mockitodemo.service.SampleDataService;

public class SampleBusinessImpl {
	
	private SampleDataService sampleDataService;
	
	public void setSampleDataService(SampleDataService sampleDataService) {
		this.sampleDataService = sampleDataService;
	}

	public int calculateSum(int[] data) {
		int sum =0;
		for(int i=0;i<data.length;i++) {
			sum +=data[i];
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int[] data = sampleDataService.retreiveSampleData();
		int sum =0;
		for(int i=0;i<data.length;i++) {
			sum +=data[i];
		}
		return sum;
	}
}
