package com.acms.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acms.entity.ConfigurationEntity;
import com.acms.model.Configuration;
import com.acms.repository.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	private ConfigurationRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Collection<ConfigurationEntity> getAllConfigurations() {
		return (Collection<ConfigurationEntity>) repository.findAllByDeleted(Boolean.FALSE);
	}

	@Override
	public Configuration saveConfiguration(Configuration configuration, boolean isSave) {
		ConfigurationEntity configurationEntity = null;
		if(isSave) {
			configuration.setCreatedTime(new Timestamp(new Date().getTime()));
			configurationEntity = modelMapper.map(configuration, ConfigurationEntity.class);
		}else {
			Optional<ConfigurationEntity> configurations = repository.findById(configuration.getId());
			configurationEntity = configurations.get();
			configurationEntity.setUpdatedTime(new Timestamp(new Date().getTime()));
			setNewValues(configurationEntity, configuration);
		}
		repository.save(configurationEntity);
		return modelMapper.map(configurationEntity, Configuration.class);
	}

	private void setNewValues(ConfigurationEntity configurationEntity, Configuration configuration) {
		if(configuration.getCategory() != null) {
			configurationEntity.setCategory(configuration.getCategory());
		}
		if(configuration.getConfigDescription() != null) {
			configurationEntity.setConfigDescription(configuration.getConfigDescription());
		}
		if(configuration.getConfigName() != null) {
			configurationEntity.setConfigName(configuration.getConfigName());
		}
		if(configuration.getDisplayName() != null) {
			configurationEntity.setDisplayName(configuration.getDisplayName());
		}
		if(configuration.getDataType() != null) {
			configurationEntity.setDataType(configuration.getDataType());
		}
		if(configuration.getConfigValue() != null) {
			configurationEntity.setConfigValue(configuration.getConfigValue());
		}		
	}
	
	@Override
	public Configuration getConfigurationById(Integer id) {
		Optional<ConfigurationEntity> configurations = repository.findById(id);
		return modelMapper.map(configurations.get(), Configuration.class);
	}

	@Override
	public boolean deleteConfiguration(Configuration configuration) {
		Optional<ConfigurationEntity> configurations = repository.findById(configuration.getId());
		ConfigurationEntity configurationEntity = modelMapper.map(configurations.get(), ConfigurationEntity.class);
		configuration.setDeleted(Boolean.TRUE);
		configuration.setUpdatedTime(new Timestamp(new Date().getTime()));
		repository.save(configurationEntity);
		return configurationEntity.isDeleted();
	}
}
