package com.acms.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acms.entity.ConfigurationEntity;
import com.acms.model.Configuration;
import com.acms.service.ConfigurationService;

@Controller
public class ConfigurationResourceImpl implements ConfigurationResource {

	@Autowired
	private ConfigurationService configurationService;

	@Override
	public Collection<ConfigurationEntity> getAllConfigurations() {
		return configurationService.getAllConfigurations();
	}

	@Override
	public Configuration saveConfiguration(Configuration configuration) {
		return configurationService.saveConfiguration(configuration, Boolean.TRUE);

	}

	@Override
	public Configuration getById(Integer id) {
		return configurationService.getConfigurationById(id);
	}

	@Override
	public Configuration updateConfiguration(Configuration configuration) {
		return configurationService.saveConfiguration(configuration, Boolean.FALSE);

	}

	@Override
	public boolean deleteConfiguration(Configuration configuration) {
		return configurationService.deleteConfiguration(configuration);
	}

}
