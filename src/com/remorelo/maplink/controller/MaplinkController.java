package com.remorelo.maplink.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.remorelo.maplink.model.Address;
import com.remorelo.maplink.model.Price;
import com.remorelo.maplink.model.PricesAtHourRange;
import com.remorelo.maplink.model.ResponseCoast;
import com.remorelo.maplink.model.ResponseRoute;
import com.remorelo.maplink.model.Route;
import com.remorelo.maplink.model.TollFees;
import com.remorelo.maplink.service.AddressService;

@RestController
public class MaplinkController {

	public static final Logger logger = LoggerFactory.getLogger(MaplinkController.class);
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(MaplinkController.class, args);
    }
	
	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<ResponseCoast> test() {

		Address addressStart = new Address();
		addressStart.setStreetName("Rua mercedes lopes");
		addressStart.setNumber("480");
		addressStart.setCity("São Paulo");
		addressStart.setState("SP");
        
        Address addressFinish = new Address();
        addressFinish.setStreetName("Av. Lauro L");
        addressFinish.setNumber("2650");
      	addressFinish.setCity("Mirassol");
      	addressFinish.setState("SP");
        
        ResponseEntity<ResponseCoast> response = findAddress(addressStart, addressFinish);
		
        return response;
	}

	
	@RequestMapping(value = "/findAddress/{addressStart}/{addressFinish}", method = RequestMethod.GET)
	public ResponseEntity<ResponseCoast> findAddress(
			@PathVariable("addressStart") Address pAddressStart,
			@PathVariable("addressFinish") Address pAddressFinish) {
		 
		if (pAddressStart == null || pAddressFinish == null) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  
	    ResponseRoute responseRoute = addressService.findAddress(pAddressStart, pAddressFinish);
		if (responseRoute == null) {
			return new ResponseEntity<ResponseCoast>(HttpStatus.NO_CONTENT);	
		}
	    
		double tollCoast = getTotalValueToll(responseRoute);
		
	    ResponseCoast response = new ResponseCoast(
	    		responseRoute.getRoutes().get(0).getSummary().getDuration(), 
				responseRoute.getRoutes().get(0).getSummary().getDistance(), 
				tollCoast);
	    
	    return new ResponseEntity<ResponseCoast>(response, HttpStatus.OK);
	}


	/**
	 * @param responseRoute
	 * @param coast
	 * @return
	 */
	private double getTotalValueToll(ResponseRoute responseRoute) {
		double coast = 0;
		for (Route route : responseRoute.getRoutes()) {
			for (TollFees toll : route.getSummary().getTollFees()) {
				for (Price price : toll.getPrices()) {
					for (PricesAtHourRange pricesAtHourRange : price.getPricesAtHourRange()) {
						coast += pricesAtHourRange.getPrice();
					}
				}
			}
		}
		return coast;
	}

}