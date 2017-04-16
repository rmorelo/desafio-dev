package com.remorelo.maplink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

	private String daysOfWeek;
	private String typeOfFare;
	private String currency;
	private double distance;
	private List<PricesAtHourRange> pricesAtHourRange;
	
	/**
	 * @return the daysOfWeek
	 */
	public String getDaysOfWeek() {
		return daysOfWeek;
	}
	/**
	 * @param daysOfWeek the daysOfWeek to set
	 */
	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	/**
	 * @return the typeOfFare
	 */
	public String getTypeOfFare() {
		return typeOfFare;
	}
	/**
	 * @param typeOfFare the typeOfFare to set
	 */
	public void setTypeOfFare(String typeOfFare) {
		this.typeOfFare = typeOfFare;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/**
	 * @return the pricesAtHourRange
	 */
	public List<PricesAtHourRange> getPricesAtHourRange() {
		return pricesAtHourRange;
	}
	/**
	 * @param pricesAtHourRange the pricesAtHourRange to set
	 */
	public void setPricesAtHourRange(List<PricesAtHourRange> pricesAtHourRange) {
		this.pricesAtHourRange = pricesAtHourRange;
	}
	
}
