package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

	private String routeIdentification;
	private Summary summary;
	
	/**
	 * @return the routeIdentification
	 */
	public String getRouteIdentification() {
		return routeIdentification;
	}
	/**
	 * @param routeIdentification the routeIdentification to set
	 */
	public void setRouteIdentification(String routeIdentification) {
		this.routeIdentification = routeIdentification;
	}
	/**
	 * @return the summary
	 */
	public Summary getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
}
