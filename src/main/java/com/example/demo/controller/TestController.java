package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.Quote;

@RestController
public class TestController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public Quote test() {		
		HttpHeaders header = new HttpHeaders();
		header.set("test", "value");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		
		HttpEntity<Map<String, String>> request = new HttpEntity<>(map, header);
		
		ResponseEntity<Quote> resp = restTemplate.exchange("http://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, request, Quote.class);
		return resp.getBody();
	}
	
	@RequestMapping(value="/testString", method = RequestMethod.GET)
	public String testString() {		
		HttpHeaders header = new HttpHeaders();
		header.set("test", "value");
		
		HttpEntity<String> request = new HttpEntity<>(header);
		
		ResponseEntity<String> resp = restTemplate.exchange("http://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, request, String.class);
		return resp.getBody().toString();
	}
	
	@RequestMapping(value="/quote", method = RequestMethod.GET)
	public Quote testquote() {		
		Quote Quote = new Quote();
		Quote.setType("type");
		return Quote;		
	}
}
