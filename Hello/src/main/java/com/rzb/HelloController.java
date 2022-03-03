package com.rzb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${metadatservice.url}")
	private String metadatserviceURL;

	@GetMapping
	public String sayHello() {

		return "Hello";
	}

	@GetMapping("/metadata")
	public String getMetadata() {

		return restTemplate.getForObject(metadatserviceURL, String.class);
	}
}
