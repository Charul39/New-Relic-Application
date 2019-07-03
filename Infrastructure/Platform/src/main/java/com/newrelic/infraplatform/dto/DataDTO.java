package com.newrelic.infraplatform.dto;

import java.util.List;

public class DataDTO {
	
	private String name;

	private List<TimeseriesDTO> timeseries;

	public DataDTO() {
		super();
	}

	public DataDTO(String name, List<TimeseriesDTO> timeseries) {
		super();
		this.name = name;
		this.timeseries = timeseries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TimeseriesDTO> getTimeseries() {
		return timeseries;
	}

	public void setTimeseries(List<TimeseriesDTO> timeseries) {
		this.timeseries = timeseries;
	}
	
}