package com.luv2code.springdemo.test;

import static org.junit.Assert.assertTrue;

import java.lang.System.Logger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.AddressService;
import com.luv2code.springdemo.service.ContactService;
import com.luv2code.springdemo.service.CustomerService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:**/spring-mvc-crud-demo-servlet_test.xml")
public class ContactTester {
	
	private static Logger myLogger = System.getLogger("ContactTester");
		
	
	
	@Autowired
	CustomerService myCustomerService;
	
	@Autowired
	ContactService myContactService;
	
//	@Test
	public void testSaveNewContact() {
		Customer myNewCustomer=new Customer("Johny", "Cash", "joahny@email");
		myCustomerService.saveCustomer(myNewCustomer);
		
		ContactPerson myNewContact=new ContactPerson("Johny", "Cash", "joahny@email");
		
		myNewCustomer=myCustomerService.saveContactToCustomer(myNewContact, myNewCustomer.getId());
		
		//we have to get list inside an active session due to Lazy Fetch
		List<ContactPerson> myContacts=myCustomerService.getContactList(myNewCustomer.getId());
		System.out.println(" Contact list was obtained lets test it now .... ");
		
		assertTrue(!myContacts.isEmpty());
		System.out.println(" List is not empty, lets see if the data are the same .... ");
		
		assertTrue(myContacts.get(0).getEmail().equals(myNewContact.getEmail()));
		System.out.println(" Data are ok, exit tests!");
	}
	
//	@Test
	public void testSaveMultipleContacts() {
		Customer myNewCustomer=new Customer("Johny", "Cash", "joahny@email");
		myCustomerService.saveCustomer(myNewCustomer);
		
		ContactPerson myNewContact1=new ContactPerson("Johny", "Cash", "joahny@email");
		ContactPerson myNewContact2=new ContactPerson("Ilias", "Mertz", "mertz@mycompany.email");
		
		myNewCustomer=myCustomerService.saveContactToCustomer(myNewContact1, myNewCustomer.getId());
		myNewCustomer=myCustomerService.saveContactToCustomer(myNewContact2, myNewCustomer.getId());
		
		//we have to get list inside an active session due to Lazy Fetch
		List<ContactPerson> myContacts=myCustomerService.getContactList(myNewCustomer.getId());
		System.out.println(" Contact list was obtained lets test it now .... ");
		
		assertTrue(!myContacts.isEmpty());
		System.out.println(" List is not empty, lets see if the data are the same .... ");
		
		assertTrue(myContacts.size()==2);
		System.out.println(" Data are ok, exit tests!");
	}
	
	@Test
	public void testSaveNewCustomerToContact() {
		ContactPerson myNewContact=new ContactPerson("Giorgos", "Orfeas", "joahny@email");
		
		myContactService.saveContact(myNewContact);
		
		Customer myNewCustomer=new Customer("Ioli", "Mertz", "joahny@email");		
		
		//save customer to contact
		myNewContact=myContactService.saveCustomertToContact(myNewCustomer, myNewContact.getId());
		
		//we have to get list inside an active session due to Lazy Fetch
		List<Customer> myCustomers=myContactService.getCustomers(myNewContact.getId());
		System.out.println(" Customer list was obtained lets test it now .... ");
		
		assertTrue(!myCustomers.isEmpty());
		System.out.println(" List is not empty, lets see if the data are the same .... ");
		
		assertTrue(myCustomers.get(0).getEmail().equals(myNewCustomer.getEmail()));
		System.out.println(" Data are ok, exit tests!");
	}
	
	

}
