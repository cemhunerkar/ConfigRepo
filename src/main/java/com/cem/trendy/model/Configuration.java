package com.cem.trendy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuration")
public class Configuration {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String type;

	private String value;

	private Boolean isActive;

	private String applicationName;

	public ConfigurationDTO toConfigDTO() {
		ConfigurationDTO dto = new ConfigurationDTO();
		dto.setName(getName());
		dto.setType(getType());
		dto.setValue(getValue());
		dto.setIsActive(getIsActive());
		dto.setApplicationName(getApplicationName());
		return dto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
