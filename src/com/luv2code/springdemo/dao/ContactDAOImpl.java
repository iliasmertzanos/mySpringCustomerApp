package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class ContactDAOImpl implements ContactDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ContactPerson getContact(int contactId) {
		Session mySession=sessionFactory.getCurrentSession();
		
		ContactPerson myContact=mySession.get(ContactPerson.class, contactId);
		
		return myContact;
	}
	
	@Override
	public List<Customer> getCustomerList(int contactId){
		
		Session mySession=sessionFactory.getCurrentSession();
		
		ContactPerson myContact=mySession.get(ContactPerson.class, contactId);
		
		List<Customer> myCustomers=myContact.getMyCustomerList();
		
//		System.out.println(" Contact List obtained inside ContactDAOImpl: "+myCustomers);
		
		return myCustomers;
				
	}

	@Override
	public ContactPerson updateContact(ContactPerson myContact) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		return (ContactPerson)currentSession.merge(myContact);
	}

	@Override
	public void saveContact(ContactPerson myNewContact) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(myNewContact);
		
	}
	
}
