package com.damitht.unittesting.unittesting.spike;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	String actualPartResponseEscape = "{\"id\":1,\"name\":\"Ball 2\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		String expectedPartResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
//		JSONAssert.assertEquals(expectedResponse, actualPartResponse, true);
		JSONAssert.assertEquals(expectedPartResponse, actualResponse, false);
		
		String expectedResponseEscape = "{\"id\":1,\"name\": \"Ball 2\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponseEscape, actualPartResponseEscape, false);
		
		String expectedResponseWithoutEscape = "{id:1, name:Ball, price:10}";
		JSONAssert.assertEquals(expectedResponseWithoutEscape, actualResponse, false);
	}

}
