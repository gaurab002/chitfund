package com.chitfund.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class TestController {

	@GetMapping("/test")
	public String getTest() {
		return "hello";
	}
}
