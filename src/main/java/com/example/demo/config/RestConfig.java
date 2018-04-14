package com.example.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;

@Configuration
@EnableAutoConfiguration
public class RestConfig {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate template = restTemplateBuilder
				.requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))	
				.interceptors(new CustomInterceptor())
//				.messageConverters(setMappingJackson2HttpMessageConverter())
				.setConnectTimeout(10000)
				.setReadTimeout(10000)
				.build();
		return template;
	}
	
//	private MappingJackson2HttpMessageConverter setMappingJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
////		mappingJackson2HttpMessageConverter.setPrettyPrint(true);
//		mappingJackson2HttpMessageConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		mappingJackson2HttpMessageConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
////		mappingJackson2HttpMessageConverter.getObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
//		return mappingJackson2HttpMessageConverter; 
//	}
}
