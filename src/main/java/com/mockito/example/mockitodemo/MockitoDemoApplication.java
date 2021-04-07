package com.mockito.example.mockitodemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

class object implements Serializable{
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getTwo() {
		return two;
	}
	public void setTwo(int two) {
		this.two = two;
	}
	int  one;
	int two;
	object(int one,int two){
		this.one = one;
		this.two = two;
	}
	object(){
		super();
	}
}

@SpringBootApplication
@EnableSpringConfigured
public class MockitoDemoApplication implements CommandLineRunner{

	@Value("${check.value}")
	private String val;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public static void main(String[] args) {
		SpringApplication.run(MockitoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("vall---"+val);
		List<object> objList = new ArrayList<>();
		object ob = new object(1,2);
		object ob1 = new object(3,4);
		objList.add(ob);
		objList.add(ob1);
		System.out.println("---------------");
		System.out.println(objectMapper.writeValueAsString(objList));
		String json =objectMapper.writeValueAsString(ob);
		JsonNode ab=new ObjectMapper().readTree(json);
		String se = ab.get("one").asText();
		System.out.println("JsonNode --"+se);
		Gson gson = new Gson();
//		List<JsonObject> jsonObject = gson.fromJson(json, JsonObject);
//		System.out.println(jsonObject);
//		JsonNode parent= new ObjectMapper().readTree(json);
//		String content = parent.path("one").asText();
//		System.out.println(content);
		JsonObject mainJson = new JsonObject();
		JsonObject innerJson = new JsonObject();
		JsonObject innerJson1 = new JsonObject();
		innerJson.addProperty("@iot.id", "31");
		innerJson1.addProperty("responseCode", "31");
		innerJson.add("moreInfo", innerJson1);
		mainJson.add("Datastream", innerJson);  // <-- here the nesting happens
		mainJson.addProperty("result", 12.3);
		System.out.println(mainJson.toString());
		JsonNode x = new ObjectMapper().readTree(mainJson.toString());
		System.out.println("subbb1"+x.get("Datastream").get("moreInfo").get("responseCode").asText());
	}

}
