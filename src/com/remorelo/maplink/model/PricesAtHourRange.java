package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricesAtHourRange {

	private boolean defaultValue;
	private String startHour;
	private String endHour;
	private double price;
	
	/**
	 * @return the defaultValue
	 */
	public boolean isDefaultValue() {
		return defaultValue;
	}
	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
	/**
	 * @return the startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * @param startHour the startHour to set
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	/**
	 * @return the endHour
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
