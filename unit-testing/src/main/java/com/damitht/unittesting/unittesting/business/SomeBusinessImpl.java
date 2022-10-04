package com.damitht.unittesting.unittesting.business;

import java.util.List;

import com.damitht.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
		
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
	public Integer calculateSum(List<Integer> data) {
		return data.stream()
				.reduce(0, Integer::sum);
	}
	
	public Integer calculateSumUsingDataService() {
		List<Integer> data = someDataService.retrieveAllData();
		
		saveToDB(new Integer(3));
		
		return data.stream()
				.reduce(0, Integer::sum);
	}
	
	public void saveToDB(Integer i) {
		System.out.println("Saving I -> "+ i);
	}
}
