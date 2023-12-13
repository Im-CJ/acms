package com.acms.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acms.entity.ConfigurationEntity;
import com.acms.model.Configuration;
import com.acms.service.ConfigurationService;

@Controller
public class ConfigurationResourceImpl implements ConfigurationResource {

	
	private final ConfigurationService configurationService;
	
	private final ModelMapper modelMapper;
	
    @Autowired
    public ConfigurationResourceImpl(ConfigurationService configurationService) {
        this.configurationService = configurationService;
		this.modelMapper = new ModelMapper();
    }

	@Override
	public List<Configuration> getAllConfigurations() {
		return configurationService.getAllConfigurations().stream().map(this::convertToModel)
				.collect(Collectors.toList());
	}

	private Configuration convertToModel(ConfigurationEntity configEntity) {
		return modelMapper.map(configEntity, Configuration.class);
	}

	@Override
	public Configuration saveConfiguration(Configuration configuration) {
		return configurationService.saveConfiguration(configuration, Boolean.TRUE);

	}

	@Override
	public Configuration getById(int id) {
		return configurationService.getConfigurationById(id);
	}

	@Override
	public Configuration updateConfiguration(Configuration configuration) {
		return configurationService.saveConfiguration(configuration, Boolean.FALSE);

	}

	@Override
	public boolean deleteConfiguration(int id) {
		return configurationService.deleteConfiguration(id);
	}

}
