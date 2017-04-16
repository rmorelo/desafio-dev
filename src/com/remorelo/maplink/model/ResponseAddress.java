package com.remorelo.maplink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAddress {

	private List<Address> results;
	private String status;
	
	/**
	 * @return the results
	 */
	public List<Address> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<Address> results) {
		this.results = results;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "ResponseAddress{" +
		        "results=" + results +
		        ", status=" + status +
                '}';
    }	
	
}
