package com.chitfund.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class TestController {

	@GetMapping("/test")
	@Scheduled(fixedRate = 5000)
	public String getTest() {
		return "hello";
	}
}
