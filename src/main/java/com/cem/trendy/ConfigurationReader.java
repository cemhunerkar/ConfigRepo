package com.cem.trendy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.cem.trendy.persistence.ConfigurationRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
@EnableScheduling
public class ConfigurationReader {

	@Autowired
	ConfigurationRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationReader.class, args);
	}

	@CacheEvict(allEntries = true, value = { "confList", "confByName" })
	@Scheduled(fixedDelayString = "${refresh}", initialDelay = 500)
	public void reportCacheRefresh() {
		System.out.println("Refreshing Cache...");
	}

}
