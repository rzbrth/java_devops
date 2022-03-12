package com.rzb;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${metadatservice.url}")
	private String metadatserviceURL;

	@Value("${owner.name}")
	private String ownerName;

	@Value("${server.port}")
	private int port;

	@GetMapping
	public String sayHello() {

		return "Hello" + " " + ownerName;
	}

	@GetMapping("/meta")
	public String getMetaInfo() throws UnknownHostException {

		return "{\"port\" :" + port + ",\"hostAddress\" : " + InetAddress.getLocalHost().getHostAddress()
				+ ",\"hostName\" : " + InetAddress.getLocalHost().getHostName() + "}";
	}

	@GetMapping("/metadata")
	public String getMetadata() {

		return restTemplate.getForObject(metadatserviceURL, String.class);
	}

}
