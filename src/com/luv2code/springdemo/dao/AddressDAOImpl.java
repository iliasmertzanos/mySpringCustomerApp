package com.luv2code.springdemo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Override
	public List<Address> findAllAdrressesOfCustomer(int customerId) {
//		Address myAddress=new Address(6,"Salaminos","12A","Greece","Larisa","Larisa","41221") ;
		return Arrays.asList(new Address());
	}

}
