package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMocktest {

	List mock = Mockito.mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10).thenReturn(15);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
		assertEquals(15, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Damith");
		assertEquals("Damith", mock.get(0));
	}

	@Test
	public void returnWithGenericParam() {
		when(mock.get(anyInt())).thenReturn("Damith");
		assertEquals("Damith", mock.get(0));
		assertEquals("Damith", mock.get(1));
	}
	
	@Test
	public void verificationBasics() {
		String value1 = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		mock.add("Something");
		
		//verificaton
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("Something", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		mock.add("Something1");
		mock.add("Something2");
		
		//verificaton
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("Something1", allValues.get(0));
		assertEquals("Something2", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = Mockito.mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());
		
		verify(arrayListSpy).add("Test3");
	}
}
