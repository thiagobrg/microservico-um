package com.microservice.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Thiago Guimarãesss
 * @date 27/02/2023 20:04:00
 */
@RestController
@RequestMapping("teste")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class TesteController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${microservice.teste}")
	private String value;
	
	@Value("${microservice.remote.name}")
	private String remoteName;
	
	@GetMapping
	public String teste() {
		return "Value: " + value;
	}
	
	@GetMapping("/list")
	public List<String> list() {
		List<String> list = discoveryClient.getServices();
		return list;
	}
	
	@GetMapping("/comunicacao")
	public String comunicacao() {
		String response = new RestTemplate().getForObject("http://" + remoteName + "/teste", String.class);
		return "Me comuniquei com: " + response;
	}

}
