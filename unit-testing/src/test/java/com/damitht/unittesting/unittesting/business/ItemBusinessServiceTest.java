package com.damitht.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import com.damitht.unittesting.unittesting.business.ItemBusinessService;
import com.damitht.unittesting.unittesting.data.ItemRepository;
import com.damitht.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;

	@Test
	public void calculteSumUsingDataService_basic() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10),
						new Item(2, "Item2", 20, 20))
				);
		List<Item> items = business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
