package com.in28minutes.mockito.mockitodemo.business;

// Mock Database Layer
interface DataService {
	int[] retrieveAllData();
}

// Mock Business Layer
public class SomeBusinessImpl {

	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findTheGreatestFromAllData() {
		int [] data = dataService.retrieveAllData();
		
		int greatesValue = Integer.MIN_VALUE;
		
		for(int value : data) {
			if(value > greatesValue) {
				greatesValue = value;
			}
		}
		return greatesValue;
	
	}
}
