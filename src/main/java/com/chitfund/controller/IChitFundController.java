package com.chitfund.controller;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitfund.models.ChitDate;
import com.chitfund.models.ChitInfo;
import com.chitfund.models.Customer;

@RequestMapping("/chitfund")
public interface IChitFundController {

	@PostMapping("/createNewChit")
	public String createNewChit(@RequestBody ChitInfo chitInfo);
	
	@PostMapping(value ="/addCustomer",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String addCustomer(@RequestBody Customer customer);
	
	@GetMapping("/getAllChit")
	public List<ChitInfo> getAllChit();
	
	@PostMapping("/updateChitTerm")
	public String updateChitTerm(@RequestBody ChitDate chitDate);

	@GetMapping("/getChitById")
	ChitInfo getChitById(@RequestParam("id") Long id);
	
	@GetMapping("/getAllCustomers")
	List<Customer> getAllCustomers();
}
