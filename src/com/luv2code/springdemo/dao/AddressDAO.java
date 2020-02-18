package com.luv2code.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.Customer;


public interface AddressDAO {
	
	public List<Address> findAllAdrressesOfCustomer(int customerId);
	
//	public void saveAddress(Address myAddress);

}
