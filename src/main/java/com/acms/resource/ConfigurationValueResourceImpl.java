package com.acms.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acms.entity.ConfigurationValueEntity;
import com.acms.model.ConfigurationValue;
import com.acms.service.ConfigurationValueService;

@Controller
public class ConfigurationValueResourceImpl implements ConfigurationValueResource {

	@Autowired
	private ConfigurationValueService configurationValueService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ConfigurationValue> getAllConfigurationValues() {
		return configurationValueService.getAllConfigurationValues().stream().map(this::convertToModel)
				.collect(Collectors.toList());
	}

	private ConfigurationValue convertToModel(ConfigurationValueEntity configValueEntity) {
		return modelMapper.map(configValueEntity, ConfigurationValue.class);
	}

	@Override
	public ConfigurationValue saveConfigurationValue(ConfigurationValue configurationValue) {
		return configurationValueService.saveConfigurationValue(configurationValue, Boolean.TRUE);

	}

	@Override
	public ConfigurationValue getById(Integer id) {
		return configurationValueService.getConfigurationValueById(id);
	}

	@Override
	public ConfigurationValue updateConfigurationValue(ConfigurationValue configurationValue) {
		return configurationValueService.saveConfigurationValue(configurationValue, Boolean.FALSE);

	}

	@Override
	public boolean deleteConfigurationValue(ConfigurationValue configurationValue) {
		return configurationValueService.deleteConfigurationValue(configurationValue);
	}

}
