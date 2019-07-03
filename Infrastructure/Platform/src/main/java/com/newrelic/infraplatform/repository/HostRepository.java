package com.newrelic.infraplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newrelic.infraplatform.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, String> {

}