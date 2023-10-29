package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		//Passing stub to Business Layer
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();
		
		assertEquals(25,result);
	}

}

// Creating a Stubs
// It will talk to the Database Layer and then pass to Business Layer
class DataServiceStub implements DataService {
	public int[] retrieveAllData() {
		// Dummy Data
		return new int[] {25, 15, 5};
	}
}