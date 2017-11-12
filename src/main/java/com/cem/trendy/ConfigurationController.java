package com.cem.trendy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cem.trendy.model.ConfigurationDTO;
import com.cem.trendy.persistence.ConfigurationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ConfigurationController {

	@Autowired
	ConfigurationRepository repo;

	@Value(value = "${applicationName}")
	private String applicationName;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/conf/{confId}")
	public ConfigurationDTO getConf(@PathVariable Integer confId) {
		return repo.findOne(confId).toConfigDTO();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/confs")
	public List<ConfigurationDTO> getConfList() {
		return repo.find(applicationName).stream().map(x -> x.toConfigDTO()).collect(Collectors.toList());
	}

	@GetMapping("/confs/json")
	public String getConfListJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(
				repo.find(applicationName).stream().map(x -> x.toConfigDTO()).collect(Collectors.toList()));
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/conf/{confKey}")
	public <T> T GetValue(@PathVariable String confKey) {
		ConfigurationDTO config = repo.findByName(confKey, applicationName).toConfigDTO();
		switch (config.getType()) {
		case "String":
			return (T) new String(config.getValue());
		case "Boolean":
			return (T) new Boolean(config.getValue() == "1" ? "True" : "False");
		case "Int":
			return (T) new Integer(config.getValue());
		}
		return (T) "Error";
	}

}
