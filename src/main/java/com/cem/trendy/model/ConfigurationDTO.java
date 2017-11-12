package com.cem.trendy.model;

public class ConfigurationDTO {

	private String name;

	private String type;

	private String value;

	private Boolean isActive;

	private String applicationName;

	public Configuration toConfiguration() {
		Configuration config = new Configuration();
		config.setName(getName());
		config.setType(getType());
		config.setValue(getValue());
		config.setIsActive(getIsActive());
		config.setApplicationName(getApplicationName());
		return config;
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
