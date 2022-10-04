package com.damitht.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.damitht.unittesting.unittesting.business.ItemBusinessService;
import com.damitht.unittesting.unittesting.controller.ItemController;
import com.damitht.unittesting.unittesting.model.Item;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

@WebMvcTest(ItemController.class)
public class ItemControllertest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
//				.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
//				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
				.andReturn();
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 15));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2, name:Item2,price:10}"))
				.andReturn();
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10), new Item(3, "Item3", 20, 20))
				);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2, name:Item2,price:10}, {id:3, name:Item3,price:20}]"))
				.andReturn();
		
	}

}
