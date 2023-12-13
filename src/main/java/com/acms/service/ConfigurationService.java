package com.acms.service;

import java.util.Collection;

import com.acms.entity.ConfigurationEntity;
import com.acms.model.Configuration;

public interface ConfigurationService {
	
	Collection<ConfigurationEntity> getAllConfigurations();
	
	Configuration saveConfiguration(Configuration configuration, boolean isSave);
	
	Configuration getConfigurationById(int id);
	 
	boolean deleteConfiguration(int id);
}
