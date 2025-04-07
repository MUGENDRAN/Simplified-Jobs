package com.mugi.simplified_jobs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mugi.simplified_jobs.model.Company;

public interface Repository extends JpaRepository<Company, Long>{
	
	
	@Query(value="select * from defaultdb.company where company_name = :name",nativeQuery = true)
	public List<Company> findByName(@Param("name") String name);

}
