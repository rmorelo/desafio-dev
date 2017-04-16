package com.remorelo.maplink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRoute {

	private Status status;
	private List<Route> routes;
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return routes;
	}

	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
    public String toString() {
        return "ResponseRoute{" +
		        "routes=" + routes +
		        ", status=" + status +
                '}';
    }	
	
}
