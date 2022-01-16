package com.example.ablakozo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class AblakozoCliClientApplication {
	
	private static final String GET_ALL_USERS = "http://localhost:8080/api/user/all";
	private static final String GET_USER_BY_ID = "http://localhost:8080/api/user={userId}";
	private static final String GET_ALL_APP_BY_USER_ID = "http://localhost:8080/api/user={userId}/apps";
	private static final String POST_USER = "http://localhost:8080/api/user={userId}/add";
	private static final String POST_APP = "http://localhost:8080/api/user={userId}/apps/add";
	private static final String PUT_EDIT_USER = "http://localhost:8080/api/{userId}/edit";
	private static final String PUT_EDIT_APP = "http://localhost:8080/api/{appId}/edit";
	private static final String DELETE_USER = "http://localhost:8080/api/{userId}/delete";
	private static final String DELETE_APP = "http://localhost:8080/api/app={appId}/delete";
	
	
// ------------------------------
//	NEM MŰKÖDIK A PROJEKT
//	 (CSAK PRÓBÁLKOZÁS)
//-------------------------------


	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		SpringApplication.run(AblakozoCliClientApplication.class, args);
		
		callGetAllUsersAPI();
		
	}
	
	
	private static void callGetAllUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS, HttpMethod.GET, entity, String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<User> allUsers=new ArrayList<User>();
		try {
			
			allUsers = mapper.readValue(result.toString(), List.class);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		for (User u : allUsers) {
			u.toString();
		}
	}
	
	private static void callGetUserById(int id) {
		Map<String,Integer> param = new HashMap<>();
		param.put("userId",id);
		
		User user = restTemplate.getForObject(GET_USER_BY_ID, User.class, param);
	}
	
	private static void callCreateUser(User user) {
		ResponseEntity<User> user2 = restTemplate.postForEntity(POST_USER, user, User.class);
	}
	
	private static void callUpdateUser(int id, User user) {
		Map<String,Integer> param = new HashMap<>();
		param.put("userId",id);
		User updateUser = user;
		restTemplate.put(PUT_EDIT_USER, updateUser, param);
		
	}
	
	private static void callDeleteUser(int id) {
		Map<String,Integer> param = new HashMap<>();
		param.put("userId",id);
		restTemplate.delete(DELETE_USER, param);
	}

}
