package com.remorelo.maplink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	private String name;
	private String state;
	
	public City() {
	}
	
	public City(String name, String state) {
		super();
		this.name = name;
		this.state = state;
	}
	
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

	@Override
    public String toString() {
        return "City{" +
		        "name=" + name +
		        ", state=" + state +
                '}';
    }	
	
}
