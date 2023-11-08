package com.acms.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acms.entity.ConfigurationValueEntity;
import com.acms.model.ConfigurationValue;
import com.acms.service.ConfigurationValueService;

@Controller
public class ConfigurationValueResourceImpl implements ConfigurationValueResource {

	@Autowired
	private ConfigurationValueService configurationValueService;

	@Override
	public Collection<ConfigurationValueEntity> getAllConfigurationValues() {
		return configurationValueService.getAllConfigurationValues();
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
