package com.microservice.teste.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Thiago Guimarãesss
 * @date 27/02/2023 20:04:00
 */
@RestController
@RequestMapping("teste")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class TesteController {
	
	@Value("${microservice.teste}")
	private String value;
	
	@GetMapping
	public String teste() {
		return "Value: " + value;
	}

}
