package com.cem.trendy.persistence;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cem.trendy.model.Configuration;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

	@Query(value = "SELECT * FROM configuration WHERE application_name= :applicationName AND is_active=1", nativeQuery = true)
	@Cacheable("confList")
	public List<Configuration> find(@Param("applicationName") String applicationName);

	@Query(value = "SELECT * FROM configuration WHERE name= :name AND application_name= :applicationName AND is_active=1", nativeQuery = true)
	@Cacheable("confByName")
	public Configuration findByName(@Param("name") String name, @Param("applicationName") String applicationName);

}
