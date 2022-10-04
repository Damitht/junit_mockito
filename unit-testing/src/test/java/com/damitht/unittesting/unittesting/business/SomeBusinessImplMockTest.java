package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.damitht.unittesting.unittesting.business.SomeBusinessImpl;
import com.damitht.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

	@InjectMocks
	SomeBusinessImpl businessImpl = new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock;
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<Integer>() {{add(1); add(2); add(3);}});
		assertEquals(6, businessImpl.calculateSumUsingDataService());
		
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<Integer>());
		assertEquals(0, businessImpl.calculateSumUsingDataService());
		
	}
	
	@Test
	public void calculateSumUsingDataService_oneVaue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<Integer>() {{add(1);}});
		assertEquals(1, businessImpl.calculateSumUsingDataService());
		
	}

}
