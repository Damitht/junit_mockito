package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.damitht.unittesting.unittesting.business.SomeBusinessImpl;
import com.damitht.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImpleDamithMockTest {

	@InjectMocks
	SomeBusinessImpl businessImpl = Mockito.mock(SomeBusinessImpl.class);
	
	@Mock
	SomeDataService dataServiceMock;
	
	@Test
	public void test() {
//		when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<Integer>());
		businessImpl.calculateSumUsingDataService();
		verify(businessImpl, atLeastOnce()).saveToDB(anyInt());
	}

}
