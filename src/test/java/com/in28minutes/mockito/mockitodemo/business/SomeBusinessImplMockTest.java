package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findTheGreatestFromAllData_basicScenario() {
//		DataService dataServiceMock = mock(DataService.class);
//		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		
		// now we can simply use :
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
		int result = businessImpl.findTheGreatestFromAllData();
		
		assertEquals(25,result);
	}
	
	@Test
	void findTheGreatestFromAllData_oneValue() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25,result);
	}

}

/*Note:
 * By using mock when we need to use other scenarios then we don't need 
 * to implement interface (DataService) again and again
 * 
 * */
 