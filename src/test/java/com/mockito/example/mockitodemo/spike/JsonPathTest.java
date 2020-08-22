package com.mockito.example.mockitodemo.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":10000,\"name\":\"Book\",\"quantity\":2}," + 
				"{\"id\":10001,\"name\":\"Table\",\"quantity\":3}," + 
				"{\"id\":10002,\"name\":\"Pen\",\"quantity\":4}," + 
				"]";
		DocumentContext documentContext=JsonPath.parse(responseFromService);
		int length=documentContext.read("$.length()");
		assertThat(length).isEqualTo(3);
		List<Integer> ids = documentContext.read("$..id");
		assertThat(ids).contains(10000,10001,10002);
		System.out.println(documentContext.read("$.[1]").toString());
		System.out.println(documentContext.read("$.[0:2]").toString());
		System.out.println(documentContext.read("$.[?(@.name=='Table')]").toString());
	}
}
