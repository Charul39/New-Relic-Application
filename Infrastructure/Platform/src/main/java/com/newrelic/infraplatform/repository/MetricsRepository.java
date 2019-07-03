package com.newrelic.infraplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newrelic.infraplatform.dto.ValuesDTO;
import com.newrelic.infraplatform.model.Metrics;

@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Long> {
	
	//Return Distinct Times Values
	public static final String FIND_TIMES = "SELECT DISTINCT from_time"
			+ " FROM metrics WHERE test_run_id=:test_run_id";
	@Query(value = FIND_TIMES, nativeQuery = true)
	public List<Long> getTimesList(@Param("test_run_id") Integer test_run_id);
	
	
	//Return Data for each Time - cpu_percent_host
	public static final String FIND_DATA_1 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTcpuPercentHost, m.cpuPercentHost) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_1)
	public List<ValuesDTO> getData_cpu_percent_host(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - load_average_fifteen_minute
	public static final String FIND_DATA_2 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTloadAverageFifteenMinute, m.loadAverageFifteenMinute) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_2)
	public List<ValuesDTO> getData_load_average_fifteen_minute(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);

	//Select Data for each Time - load_average_one_minute
	public static final String FIND_DATA_3 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTloadAverageOneMinute, m.loadAverageOneMinute) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_3)
	public List<ValuesDTO> getData_load_average_one_minute(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - memory_used_bytes
	public static final String FIND_DATA_4 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTmemoryUsedBytes, m.memoryUsedBytes) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_4)
	public List<ValuesDTO> getData_memory_used_bytes(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - cpu_percent_process
	public static final String FIND_DATA_5 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTcpuPercentProcess, m.cpuPercentProcess) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_5)
	public List<ValuesDTO> getData_cpu_percent_process(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - io_total_read_bytes
	public static final String FIND_DATA_6 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTioTotalReadBytes, m.ioTotalReadBytes) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_6)
	public List<ValuesDTO> getData_io_total_read_bytes(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - io_total_write_bytes
	public static final String FIND_DATA_7 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTioTotalWriteBytes, m.ioTotalWriteBytes) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_7)
	public List<ValuesDTO> getData_io_total_write_bytes(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - memory_resident_size_bytes
	public static final String FIND_DATA_8 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTmemoryResidentSizeBytes, m.memoryResidentSizeBytes) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_8)
	public List<ValuesDTO> getData_memory_resident_size_bytes(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
	//Select Data for each Time - thread_count
	public static final String FIND_DATA_9 = "SELECT new "
			+ "com.newrelic.infraplatform.dto.ValuesDTO(m.HOSTthreadCount, m.threadCount) "
			+ "FROM Metrics m where m.from_time = :from_time and m.test_run_id=:test_run_id";
	@Query(value = FIND_DATA_9)
	public List<ValuesDTO> getData_thread_count(@Param("test_run_id") Integer test_run_id, @Param("from_time") Long from_time);
	
}
