package com.acms.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acms.entity.ConfigurationValueEntity;
import com.acms.model.ConfigurationValue;
import com.acms.repository.ConfigurationValueRepository;

@Service
public class ConfigurationValueServiceImpl implements ConfigurationValueService {

	@Autowired
	private ConfigurationValueRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Collection<ConfigurationValueEntity> getAllConfigurationValues() {
		return (Collection<ConfigurationValueEntity>) repository.findAll();
	}

	@Override
	public ConfigurationValue saveConfigurationValue(ConfigurationValue configurationValue, boolean isSave) {
		if(isSave) {
			configurationValue.setCreatedTime(new Timestamp(new Date().getTime()));
		}else {
			configurationValue.setUpdatedTime(new Timestamp(new Date().getTime()));
		}
		ConfigurationValueEntity configurationValueEntity = modelMapper.map(configurationValue, ConfigurationValueEntity.class);
		repository.save(configurationValueEntity);
		return modelMapper.map(configurationValueEntity, ConfigurationValue.class);
	}

	@Override
	public ConfigurationValue getConfigurationValueById(Integer id) {
		Optional<ConfigurationValueEntity> configurationValues = repository.findById(id);
		return modelMapper.map(configurationValues.get(), ConfigurationValue.class);
	}

	@Override
	public boolean deleteConfigurationValue(ConfigurationValue configurationValue) {
		configurationValue.setDeleted(Boolean.TRUE);
		configurationValue.setUpdatedTime(new Timestamp(new Date().getTime()));
		ConfigurationValueEntity configurationValueEntity = modelMapper.map(configurationValue, ConfigurationValueEntity.class);
		repository.save(configurationValueEntity);
		return configurationValueEntity.isDeleted();
	}
}
