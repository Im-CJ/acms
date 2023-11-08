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
		return (Collection<ConfigurationEntity>) repository.findAll();
	}

	@Override
	public Configuration saveConfiguration(Configuration configuration, boolean isSave) {
		if(isSave) {
			configuration.setCreatedTime(new Timestamp(new Date().getTime()));
		}else {
			configuration.setUpdatedTime(new Timestamp(new Date().getTime()));
		}
		ConfigurationEntity configurationEntity = modelMapper.map(configuration, ConfigurationEntity.class);
		repository.save(configurationEntity);
		return modelMapper.map(configurationEntity, Configuration.class);
	}

	@Override
	public Configuration getConfigurationById(Integer id) {
		Optional<ConfigurationEntity> configurations = repository.findById(id);
		return modelMapper.map(configurations.get(), Configuration.class);
	}

	@Override
	public boolean deleteConfiguration(Configuration configuration) {
		configuration.setDeleted(Boolean.TRUE);
		configuration.setUpdatedTime(new Timestamp(new Date().getTime()));
		ConfigurationEntity configurationEntity = modelMapper.map(configuration, ConfigurationEntity.class);
		repository.save(configurationEntity);
		return configurationEntity.isDeleted();
	}
}
