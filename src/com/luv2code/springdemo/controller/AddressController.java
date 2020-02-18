package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService myAddressService;
	
	@GetMapping("/list")
	public String listAddresses(Model theModel) {
		
		// get customers from the service
		List<Address> theAddress = myAddressService.getAllAddresses();
				
		// add the customers to the model
		theModel.addAttribute("addresses", theAddress);
		
		return "list-addresses";
	}

}
