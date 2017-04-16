package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	private String countryCode;
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
    public String toString() {
        return "Country{" +
		        "countryCode=" + countryCode +
                '}';
    }	
	
}
