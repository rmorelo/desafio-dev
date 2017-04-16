package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TollAddress {

	private String streetName;
	private String city;
	private String countrySubdivision;
	private String country;
	
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the countrySubdivision
	 */
	public String getCountrySubdivision() {
		return countrySubdivision;
	}

	/**
	 * @param countrySubdivision the countrySubdivision to set
	 */
	public void setCountrySubdivision(String countrySubdivision) {
		this.countrySubdivision = countrySubdivision;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
    public String toString() {
        return "TollAddress{" +
		        "streetName=" + streetName +
		        ", city=" + city +
		        ", countrySubdivision=" + countrySubdivision +
		        ", country=" + country +
                '}';
    }	
}
