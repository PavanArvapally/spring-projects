package com.springboot.workers.crudapi.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
	@GetMapping("/")
	public String welcome() {
		return "<h1>Hello visitor !! Today is "+ new Date() + "</h1>";
	}
}