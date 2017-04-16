package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCoast {

	private double duration;
	private double distance;
	private double gasCoast;
	private double tollCoast;
	private double totalCoast;
	
	/**
	 * 
	 */
	public ResponseCoast() {
		super();
	}

	/**
	 * @param duration
	 * @param distance
	 * @param gasCoast
	 * @param totalCoast
	 */
	public ResponseCoast(double duration, double distance, double tollCoast) {
		super();
		this.duration = duration;
		this.distance = distance;
		this.tollCoast = tollCoast;
	}

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
	 * @return the tollCoast
	 */
	public double getTollCoast() {
		return tollCoast;
	}

	/**
	 * @param tollCoast the tollCoast to set
	 */
	public void setTollCoast(double tollCoast) {
		this.tollCoast = tollCoast;
	}

	/**
	 * @return the gasCoast
	 */
	public double getGasCoast() {
		double gasValue = 3.30;
		if (distance > 0) {
			double kilometers = (distance / 1000);
			double consume = 10;
			gasCoast = ((kilometers / consume) * gasValue);
		}
		return gasCoast;
	}

	/**
	 * @return the totalCoast
	 */
	public double getTotalCoast() {
		return gasCoast + tollCoast;
	}

	@Override
    public String toString() {
        return "ResponseCoast{" +
		        "duration=" + duration +
		        ", distance=" + distance +
		        ", gasCoast=" + gasCoast +
		        ", totalCoast=" + totalCoast +
                '}';
    }	
	
}
