package com.damitht.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.damitht.unittesting.unittesting.data.ItemRepository;
import com.damitht.unittesting.unittesting.model.Item;

@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;

	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
		assertEquals(15, items.get(2).getPrice());
	}

}
