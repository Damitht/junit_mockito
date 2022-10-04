package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.damitht.unittesting.unittesting.business.SomeBusinessImpl;
import com.damitht.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public List<Integer> retrieveAllData() {
//		return new ArrayList<Integer>() {{add(1); add(2); add(3);}};
		return new ArrayList<Integer>() {};
	}
	
}

public class SomeBusinessImplStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		Integer actualResult = businessImpl.calculateSum(new SomeDataServiceStub().retrieveAllData());
		Integer expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		Integer actualResult = businessImpl.calculateSum(new ArrayList<Integer>() {{}});
		Integer expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void calculateSumUsingDataService_oneVaue() {
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		Integer actualResult = businessImpl.calculateSum(new ArrayList<Integer>() {{}});
		Integer expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
		
	}

}
