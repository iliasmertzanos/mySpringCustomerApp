package com.luv2code.springdemo.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.AddressService;
import com.luv2code.springdemo.service.CustomerService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:**/spring-mvc-crud-demo-servlet_test.xml")
public class CustomerTester {
	
	@Autowired
	CustomerService myCustomerService;
	
	@Test
	public void testSaveNewAddress() {
		Customer myNewCustomer=new Customer("Johny", "Cash", "joahny@email");
		myCustomerService.saveCustomer(myNewCustomer);
		
		Address myAddress=new Address("MainStreet", "66", "Germany", "Saxony", "Kölnm", "41221");
		myNewCustomer=myCustomerService.saveAddressToCustomer(myAddress, myNewCustomer.getId());
		
		assertTrue(!myNewCustomer.getMyAddressesList().isEmpty());
		List<Address> myAddressList=myCustomerService.getCustomer(myNewCustomer.getId()).getMyAddressesList();
		assertTrue(!myAddressList.isEmpty());
		assertTrue(myAddressList.get(0).getStreet().equals(myAddress.getStreet()));
	}

}
