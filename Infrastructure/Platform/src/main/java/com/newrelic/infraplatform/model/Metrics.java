package com.newrelic.infraplatform.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "Metrics", indexes = {@Index(columnList = "test_run_id" , name = "test_run_id")})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metrics implements Serializable{
	
	
	private Integer test_run_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long metric_id;
	
	private Long from_time;
	
	private Long to_time;

	private Double cpuPercentHost;
	
	private Double loadAverageFifteenMinute;
	
	private Double loadAverageOneMinute;
	
	private Double memoryUsedBytes;
	
	private Double cpuPercentProcess;
	
	private Double ioTotalReadBytes;
	
	private Double ioTotalWriteBytes;
	
	private Double memoryResidentSizeBytes;
	
	private Double threadCount;

	private String HOSTcpuPercentHost;
	
	private String HOSTloadAverageFifteenMinute;
	
	private String HOSTloadAverageOneMinute;
	
	private String HOSTmemoryUsedBytes;
	
	private String HOSTcpuPercentProcess;
	
	private String HOSTioTotalReadBytes;
	
	private String HOSTioTotalWriteBytes;
	
	private String HOSTmemoryResidentSizeBytes;
	
	private String HOSTthreadCount;

	public Metrics() {
		super();
	}

	public Metrics(Integer test_run_id, Long metric_id, Long from_time, Long to_time,
			Double cpuPercentHost, Double loadAverageFifteenMinute, Double loadAverageOneMinute, Double memoryUsedBytes,
			Double cpuPercentProcess, Double ioTotalReadBytes, Double ioTotalWriteBytes, Double memoryResidentSizeBytes,
			Double threadCount, String hOSTcpuPercentHost, String hOSTloadAverageFifteenMinute,
			String hOSTloadAverageOneMinute, String hOSTmemoryUsedBytes, String hOSTcpuPercentProcess,
			String hOSTioTotalReadBytes, String hOSTioTotalWriteBytes, String hOSTmemoryResidentSizeBytes,
			String hOSTthreadCount) {
		super();
		this.test_run_id = test_run_id;
		this.metric_id = metric_id;
		this.from_time = from_time;
		this.to_time = to_time;
		this.cpuPercentHost = cpuPercentHost;
		this.loadAverageFifteenMinute = loadAverageFifteenMinute;
		this.loadAverageOneMinute = loadAverageOneMinute;
		this.memoryUsedBytes = memoryUsedBytes;
		this.cpuPercentProcess = cpuPercentProcess;
		this.ioTotalReadBytes = ioTotalReadBytes;
		this.ioTotalWriteBytes = ioTotalWriteBytes;
		this.memoryResidentSizeBytes = memoryResidentSizeBytes;
		this.threadCount = threadCount;
		HOSTcpuPercentHost = hOSTcpuPercentHost;
		HOSTloadAverageFifteenMinute = hOSTloadAverageFifteenMinute;
		HOSTloadAverageOneMinute = hOSTloadAverageOneMinute;
		HOSTmemoryUsedBytes = hOSTmemoryUsedBytes;
		HOSTcpuPercentProcess = hOSTcpuPercentProcess;
		HOSTioTotalReadBytes = hOSTioTotalReadBytes;
		HOSTioTotalWriteBytes = hOSTioTotalWriteBytes;
		HOSTmemoryResidentSizeBytes = hOSTmemoryResidentSizeBytes;
		HOSTthreadCount = hOSTthreadCount;
	}

	

	public Integer getTest_run_id() {
		return test_run_id;
	}

	public void setTest_run_id(Integer test_run_id) {
		this.test_run_id = test_run_id;
	}

	public Long getMetric_id() {
		return metric_id;
	}

	public void setMetric_id(Long metric_id) {
		this.metric_id = metric_id;
	}

	

	public Double getCpuPercentHost() {
		return cpuPercentHost;
	}

	public void setCpuPercentHost(Double cpuPercentHost) {
		this.cpuPercentHost = cpuPercentHost;
	}

	public Double getLoadAverageFifteenMinute() {
		return loadAverageFifteenMinute;
	}

	public void setLoadAverageFifteenMinute(Double loadAverageFifteenMinute) {
		this.loadAverageFifteenMinute = loadAverageFifteenMinute;
	}

	public Double getLoadAverageOneMinute() {
		return loadAverageOneMinute;
	}

	public void setLoadAverageOneMinute(Double loadAverageOneMinute) {
		this.loadAverageOneMinute = loadAverageOneMinute;
	}

	public Double getMemoryUsedBytes() {
		return memoryUsedBytes;
	}

	public void setMemoryUsedBytes(Double memoryUsedBytes) {
		this.memoryUsedBytes = memoryUsedBytes;
	}

	public Double getCpuPercentProcess() {
		return cpuPercentProcess;
	}

	public void setCpuPercentProcess(Double cpuPercentProcess) {
		this.cpuPercentProcess = cpuPercentProcess;
	}

	public Double getIoTotalReadBytes() {
		return ioTotalReadBytes;
	}

	public void setIoTotalReadBytes(Double ioTotalReadBytes) {
		this.ioTotalReadBytes = ioTotalReadBytes;
	}

	public Double getIoTotalWriteBytes() {
		return ioTotalWriteBytes;
	}

	public void setIoTotalWriteBytes(Double ioTotalWriteBytes) {
		this.ioTotalWriteBytes = ioTotalWriteBytes;
	}

	public Double getMemoryResidentSizeBytes() {
		return memoryResidentSizeBytes;
	}

	public void setMemoryResidentSizeBytes(Double memoryResidentSizeBytes) {
		this.memoryResidentSizeBytes = memoryResidentSizeBytes;
	}

	public Double getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Double threadCount) {
		this.threadCount = threadCount;
	}

	public String getHOSTcpuPercentHost() {
		return HOSTcpuPercentHost;
	}

	public void setHOSTcpuPercentHost(String hOSTcpuPercentHost) {
		HOSTcpuPercentHost = hOSTcpuPercentHost;
	}

	public String getHOSTloadAverageFifteenMinute() {
		return HOSTloadAverageFifteenMinute;
	}

	public void setHOSTloadAverageFifteenMinute(String hOSTloadAverageFifteenMinute) {
		HOSTloadAverageFifteenMinute = hOSTloadAverageFifteenMinute;
	}

	public String getHOSTloadAverageOneMinute() {
		return HOSTloadAverageOneMinute;
	}

	public void setHOSTloadAverageOneMinute(String hOSTloadAverageOneMinute) {
		HOSTloadAverageOneMinute = hOSTloadAverageOneMinute;
	}

	public String getHOSTmemoryUsedBytes() {
		return HOSTmemoryUsedBytes;
	}

	public void setHOSTmemoryUsedBytes(String hOSTmemoryUsedBytes) {
		HOSTmemoryUsedBytes = hOSTmemoryUsedBytes;
	}

	public String getHOSTcpuPercentProcess() {
		return HOSTcpuPercentProcess;
	}

	public void setHOSTcpuPercentProcess(String hOSTcpuPercentProcess) {
		HOSTcpuPercentProcess = hOSTcpuPercentProcess;
	}

	public String getHOSTioTotalReadBytes() {
		return HOSTioTotalReadBytes;
	}

	public void setHOSTioTotalReadBytes(String hOSTioTotalReadBytes) {
		HOSTioTotalReadBytes = hOSTioTotalReadBytes;
	}

	public String getHOSTioTotalWriteBytes() {
		return HOSTioTotalWriteBytes;
	}

	public void setHOSTioTotalWriteBytes(String hOSTioTotalWriteBytes) {
		HOSTioTotalWriteBytes = hOSTioTotalWriteBytes;
	}

	public String getHOSTmemoryResidentSizeBytes() {
		return HOSTmemoryResidentSizeBytes;
	}

	public void setHOSTmemoryResidentSizeBytes(String hOSTmemoryResidentSizeBytes) {
		HOSTmemoryResidentSizeBytes = hOSTmemoryResidentSizeBytes;
	}

	public String getHOSTthreadCount() {
		return HOSTthreadCount;
	}

	public void setHOSTthreadCount(String hOSTthreadCount) {
		HOSTthreadCount = hOSTthreadCount;
	}
	
	public Long getFrom_time() {
		return from_time;
	}

	public Long getTo_time() {
		return to_time;
	}	
	
	public void setFrom_time(Long from_time) {
		this.from_time = from_time;
	}

	public void setTo_time(Long to_time) {
		this.to_time = to_time;
	}

	@Override
	public String toString() {
		return "Metrics [test_run_id=" + test_run_id + ", metric_id=" + metric_id + ", from_time="
				+ from_time + ", to_time=" + to_time + ", cpuPercentHost=" + cpuPercentHost
				+ ", loadAverageFifteenMinute=" + loadAverageFifteenMinute + ", loadAverageOneMinute="
				+ loadAverageOneMinute + ", memoryUsedBytes=" + memoryUsedBytes + ", cpuPercentProcess="
				+ cpuPercentProcess + ", ioTotalReadBytes=" + ioTotalReadBytes + ", ioTotalWriteBytes="
				+ ioTotalWriteBytes + ", memoryResidentSizeBytes=" + memoryResidentSizeBytes + ", threadCount="
				+ threadCount + ", HOSTcpuPercentHost=" + HOSTcpuPercentHost + ", HOSTloadAverageFifteenMinute="
				+ HOSTloadAverageFifteenMinute + ", HOSTloadAverageOneMinute=" + HOSTloadAverageOneMinute
				+ ", HOSTmemoryUsedBytes=" + HOSTmemoryUsedBytes + ", HOSTcpuPercentProcess=" + HOSTcpuPercentProcess
				+ ", HOSTioTotalReadBytes=" + HOSTioTotalReadBytes + ", HOSTioTotalWriteBytes=" + HOSTioTotalWriteBytes
				+ ", HOSTmemoryResidentSizeBytes=" + HOSTmemoryResidentSizeBytes + ", HOSTthreadCount="
				+ HOSTthreadCount + "]";
	}
	
}