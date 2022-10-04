package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.damitht.unittesting.unittesting.business.SomeBusinessImpl;

class SomeBusinessImplTest {

	@Test
	public void calculateSum_basic() {
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		Integer actualResult = businessImpl.calculateSum(new ArrayList<Integer>() {{add(1); add(2); add(3);}});
		Integer expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void calculateSum_empty() {
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		Integer actualResult = businessImpl.calculateSum(new ArrayList<Integer>() {{}});
		Integer expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
		
	}

}
