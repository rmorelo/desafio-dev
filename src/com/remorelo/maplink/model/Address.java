package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	private String type;
	private String matchingScore;
	private Country country;
	private String countrySubdivisionAbbreviation;
	private String countrySubdivision;
	private String postalCode;
	private String city;
	private String citySubdivision;
	private String state;
	private String streetName;
	private String number;
	private String displayName;
	private Location location;
	private String precision;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the matchingScore
	 */
	public String getMatchingScore() {
		return matchingScore;
	}

	/**
	 * @param matchingScore the matchingScore to set
	 */
	public void setMatchingScore(String matchingScore) {
		this.matchingScore = matchingScore;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the countrySubdivisionAbbreviation
	 */
	public String getCountrySubdivisionAbbreviation() {
		return countrySubdivisionAbbreviation;
	}

	/**
	 * @param countrySubdivisionAbbreviation the countrySubdivisionAbbreviation to set
	 */
	public void setCountrySubdivisionAbbreviation(String countrySubdivisionAbbreviation) {
		this.countrySubdivisionAbbreviation = countrySubdivisionAbbreviation;
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
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	 * @return the citySubdivision
	 */
	public String getCitySubdivision() {
		return citySubdivision;
	}

	/**
	 * @param citySubdivision the citySubdivision to set
	 */
	public void setCitySubdivision(String citySubdivision) {
		this.citySubdivision = citySubdivision;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the precision
	 */
	public String getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(String precision) {
		this.precision = precision;
	}

	@Override
    public String toString() {
        return "Address{" +
		        "type=" + type +
		        ", matchingScore=" + matchingScore +
		        ", country=" + country.toString() +
		        ", countrySubdivisionAbbreviation=" + countrySubdivisionAbbreviation +
		        ", countrySubdivision=" + countrySubdivision +
		        ", postalCode=" + postalCode +
		        ", city=" + city +
		        ", citySubdivision=" + citySubdivision +
		        ", streetName=" + streetName +
		        ", number=" + number +
		        ", displayName=" + displayName +
		        ", location=" + location.toString() +
		        ", precision=" + precision +
                '}';
    }	
}
