package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/saveAddress")
	public String saveAddress(@ModelAttribute("address") Address theAddress,Model themodel) {
		
		int customerId=theAddress.getCustomer().getId();
		
		List<Address> myaddressList=customerService.saveAddressToCustomer(theAddress, customerId).getMyAddressesList();
		
		themodel.addAttribute("addresses", myaddressList);
		
		return "list-addresses";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		Address myAddress=new Address();
		myAddress.setCustomer(theCustomer);
		
		theModel.addAttribute("address", myAddress);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/showFormForAddAddress")
	public String showFormForAddAddress(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		Address myAddress=new Address();
		myAddress.setCustomer(theCustomer);
		
		theModel.addAttribute("address", myAddress);
		
		// send over to our form		
		return "customer-form_add_address";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/address")
	public String listAddresses(@RequestParam("customerId") int theId,
			Model theModel) {
		
		List<Address> theAddress = customerService.getAllAddresses(theId);
//		theAddress.forEach(address->System.out.println(address.toString()));
		
		theModel.addAttribute("addresses", theAddress);
		theModel.addAttribute("customerId", theId);
		
		
//		// get customers from the service
//		List<Customer> theCustomers = customerService.getCustomers();
//				
//		// add the customers to the model
//		theModel.addAttribute("customers", theCustomers);
		
		return "list-addresses";
	}
}










