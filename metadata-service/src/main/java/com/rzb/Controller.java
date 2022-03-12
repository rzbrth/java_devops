package com.rzb;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {
	
	@Autowired
	private MetaRepository merarepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/metadata")
	private String getMetaData() throws JsonProcessingException {
		List<MetaData> res = merarepo.findAll();
		
		return mapper.writeValueAsString(res);
	}
	
	@GetMapping("/meta")
	public String getMetaInfo() throws UnknownHostException {

		return "{\"port\" :" + port + ",\"hostAddress\" : " + InetAddress.getLocalHost().getHostAddress()
				+ ",\"hostName\" : " + InetAddress.getLocalHost().getHostName() + "}";
	}
	@GetMapping
	public String getVersion() {

		return appVersion;
	}
}
