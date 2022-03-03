package com.rzb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/metadata")
public class Controller {
	
	@Autowired
	private MetaRepository merarepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@GetMapping
	private String getMetaData() throws JsonProcessingException {
		List<MetaData> res = merarepo.findAll();
		
		return mapper.writeValueAsString(res);
	}

}
