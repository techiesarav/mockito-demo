package com.mockito.example.mockitodemo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.testRestTemplate
				.getForObject("/items-from-database", String.class);
		JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Book\",\"quantity\":400,\"price\":2}"
				+ ",{\"id\":2,\"name\":\"Table\",\"quantity\":300,\"price\":2}]", response, false);
	}
}
