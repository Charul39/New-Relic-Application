package com.newrelic.infraplatform.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newrelic.infraplatform.dto.DataDTO;
import com.newrelic.infraplatform.dto.TimeseriesDTO;
import com.newrelic.infraplatform.dto.ValuesDTO;
import com.newrelic.infraplatform.repository.MetricsRepository;

@Service
public class MetricsService {
	
	@Autowired
	private MetricsRepository metricsRepository;
		
	public DataDTO getData(Integer test_run_id, String parameter) { // parameter := name of graph
		
		DataDTO dataDTO = new DataDTO();
		dataDTO.setName(parameter);
		System.out.println(parameter);
		
		List<Long> timesList = metricsRepository.getTimesList(test_run_id);
		System.out.println(timesList);
		
		List<TimeseriesDTO> lTimeseriesDTOs = new ArrayList<TimeseriesDTO>();
		
		for (int i = 0; i < timesList.size(); i++) { // For each Time Stamp
			//System.out.println("In Loop");
			
			Long granularity = 20L; // Granularity of Graph
			String timezone = "GMT"; // Time zone
			
			TimeseriesDTO timeseriesDTO = new TimeseriesDTO();
			
			SimpleDateFormat jdf = new SimpleDateFormat("HH:mm:ss"); // Set Date Time Format
			jdf.setTimeZone(TimeZone.getTimeZone(timezone)); // Set Time zone
			
			Long from_timeLong = timesList.get(i); // Get Time Stamp stored as Long in DB
			Timestamp fromTimestamp = new Timestamp(from_timeLong*1000L); // 1000 Multiplication for converting to milliseconds
			Date fromDate = new Date(fromTimestamp.getTime());
			String fromString = jdf.format(fromDate); // Format the Time
			timeseriesDTO.setFrom_time(fromString);
			
			Long to_timeLong = from_timeLong + granularity;
			Timestamp toTimestamp = new Timestamp(to_timeLong*1000L); // 1000 Multiplication for converting to milliseconds
			Date toDate = new Date(toTimestamp.getTime()); // Get Time Stamp stored as Long in DB
			String toString = jdf.format(toDate);
			timeseriesDTO.setTo_time(toString);
			
			List<ValuesDTO> lValuesDTOs = new ArrayList<ValuesDTO>();
			if(parameter.equals("cpu_percent_host"))
			{
				lValuesDTOs = metricsRepository.getData_cpu_percent_host(test_run_id, from_timeLong);
				//System.out.println(lValuesDTOs);
			}
			else if (parameter.equals("load_average_fifteen_minute")){
				lValuesDTOs = metricsRepository.getData_load_average_fifteen_minute(test_run_id, from_timeLong);
			}
			else if (parameter.equals("load_average_one_minute")) {
				lValuesDTOs = metricsRepository.getData_load_average_one_minute(test_run_id, from_timeLong);
			}
			else if (parameter.equals("memory_used_bytes")) {
				lValuesDTOs = metricsRepository.getData_memory_used_bytes(test_run_id, from_timeLong);
			}
			else if (parameter.equals("cpu_percent_process")) {
				lValuesDTOs = metricsRepository.getData_cpu_percent_process(test_run_id, from_timeLong);
			}
			else if (parameter.equals("io_total_read_bytes")) {
				lValuesDTOs = metricsRepository.getData_io_total_read_bytes(test_run_id, from_timeLong);
			}
			else if (parameter.equals("io_total_write_bytes")) {
				lValuesDTOs = metricsRepository.getData_io_total_write_bytes(test_run_id, from_timeLong);
			}
			else if (parameter.equals("memory_resident_size_bytes")) {
				lValuesDTOs = metricsRepository.getData_memory_resident_size_bytes(test_run_id, from_timeLong);
			}
			else if (parameter.equals("thread_count")) {
				lValuesDTOs = metricsRepository.getData_thread_count(test_run_id, from_timeLong);
			}
			
			timeseriesDTO.setValues(lValuesDTOs);
			lTimeseriesDTOs.add(timeseriesDTO);
		}
		dataDTO.setTimeseries(lTimeseriesDTOs);
		return dataDTO;
	}
	
}