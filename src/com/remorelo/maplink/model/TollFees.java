package com.remorelo.maplink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TollFees {

	private String name;
	private Location location;
	private TollAddress address;
	private String phone;
	private String headingDirection;
	private List<Price> prices;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the address
	 */
	public TollAddress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(TollAddress address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the headingDirection
	 */
	public String getHeadingDirection() {
		return headingDirection;
	}
	/**
	 * @param headingDirection the headingDirection to set
	 */
	public void setHeadingDirection(String headingDirection) {
		this.headingDirection = headingDirection;
	}
	/**
	 * @return the prices
	 */
	public List<Price> getPrices() {
		return prices;
	}
	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
}
