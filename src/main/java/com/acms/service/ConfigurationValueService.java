package com.acms.service;

import java.util.Collection;

import com.acms.entity.ConfigurationValueEntity;
import com.acms.model.ConfigurationValue;

public interface ConfigurationValueService {
	
	Collection<ConfigurationValueEntity> getAllConfigurationValues();
	
	ConfigurationValue saveConfigurationValue(ConfigurationValue configurationValue, boolean isSave);
	
	ConfigurationValue getConfigurationValueById(Integer id);
	 
	boolean deleteConfigurationValue(ConfigurationValue configurationValue);
}
