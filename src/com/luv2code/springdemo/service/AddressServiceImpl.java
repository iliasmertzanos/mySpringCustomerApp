package com.luv2code.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AddressDAO;
import com.luv2code.springdemo.dao.AddressDAOImpl;
import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.dao.CustomerDAOImpl;
import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.Customer;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDAO myAddressDao;
	
	@Autowired
	CustomerDAO myCustomerDao;
	
	@Override
	public List<Address> getAllAddresses() {
		return myAddressDao.findAllAdrressesOfCustomer(1);
	}

	

}
