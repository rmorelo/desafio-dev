package com.remorelo.maplink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

	private double duration;
	private double distance;
	private List<TollFees> tollFees;
	
	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
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
	 * @return the tollFees
	 */
	public List<TollFees> getTollFees() {
		return tollFees;
	}
	/**
	 * @param tollFees the tollFees to set
	 */
	public void setTollFees(List<TollFees> tollFees) {
		this.tollFees = tollFees;
	}
	
}
