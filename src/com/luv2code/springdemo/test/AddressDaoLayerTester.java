package com.luv2code.springdemo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.luv2code.springdemo.dao.AddressDAO;
import com.luv2code.springdemo.dao.CustomerDAO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:**/spring-mvc-crud-demo-servlet_test.xml")
public class AddressDaoLayerTester {
	
	@Autowired
	AddressDAO myAddressDao;
	
	@Test
	public void testFindAllById() {
		myAddressDao.findAllAdrressesOfCustomer(1).forEach(address->System.out.println(address));
		System.out.println();
		assertTrue(!myAddressDao.findAllAdrressesOfCustomer(1).isEmpty());
	}

}
