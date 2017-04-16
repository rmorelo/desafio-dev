package com.remorelo.maplink.service;


import com.remorelo.maplink.model.Address;
import com.remorelo.maplink.model.ResponseRoute;

public interface AddressService {
	
	ResponseRoute findAddress(Address addressStart, Address addressFinish);
	
}
