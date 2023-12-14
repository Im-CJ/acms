package com.acms.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.acms.model.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ConfigurationApplicationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${cxf.path}")
	private String contextPath;

	private final ObjectMapper mapper = new ObjectMapper();
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return headers;
	}

	@Test
	public void testGetConfigurations_Success() {
		HttpEntity<?> entity = new HttpEntity<>("", getHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(contextPath + "/configuration");

		ResponseEntity<Configuration[]> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Configuration[].class);

		Assert.assertEquals("Response code from testGetConfigurations_Success() is  200", 200, response.getStatusCodeValue());
	}
	
	@Test
	public void testSaveConfiguration_Success() throws Exception {
		
		Configuration configuration = new Configuration();
		//configuration.setId(25);
		configuration.setConfigName("TestConfig");
		configuration.setDisplayName("TestDisplayName");
		configuration.setConfigDescription("TestDescription");
		configuration.setDataType("String");
		configuration.setCategory("Project Config");
		configuration.setCreatedTime(new Timestamp(new Date().getTime()));
		configuration.setCreatedBy("admin");
		
		HttpEntity<?> entity = new HttpEntity<>(mapper.writeValueAsString(configuration), getHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(contextPath + "/configuration");

		ResponseEntity<Configuration> response = restTemplate.exchange(builder.toUriString(),
				HttpMethod.POST, entity, Configuration.class);

		Assert.assertEquals("Response code from testSaveConfiguration_Success() is  200", 200,
				response.getStatusCodeValue());		
	}
	
	@Test
	public void testUpdateConfiguration_Success() throws Exception {
		
		Configuration configuration = new Configuration();
		configuration.setId(24);
		configuration.setConfigName("TestConfigUpdate");
		configuration.setDisplayName("TestDisplayNameUpdate");
		configuration.setConfigDescription("TestDescriptionUpdate");
		configuration.setDataType("Numeric");
		configuration.setCategory("Application Config");
		configuration.setUpdatedTime(new Timestamp(new Date().getTime()));
		configuration.setUpdatedBy("user");
		
		HttpEntity<?> entity = new HttpEntity<>(mapper.writeValueAsString(configuration), getHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(contextPath + "/configuration");

		ResponseEntity<Configuration> response = restTemplate.exchange(builder.toUriString(),
				HttpMethod.PUT, entity, Configuration.class);

		Assert.assertEquals("Response code from testUpdateConfiguration_Success() is  200", 200,
				response.getStatusCodeValue());		
	}

	@Test
	public void testGetConfigurationById_Success() throws JsonProcessingException {
		HttpEntity<?> entity = new HttpEntity<>(mapper.writeValueAsString("24"), getHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(contextPath + "/configuration/{id}");

		ResponseEntity<Configuration> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Configuration.class);

		Assert.assertEquals("Response code from testGetConfigurationById_Success() is  404", 404, response.getStatusCodeValue());
	}
	
	@Test
	public void testDeleteConfigurationById_Success() throws JsonProcessingException {
		HttpEntity<?> entity = new HttpEntity<>(mapper.writeValueAsString("24"), getHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(contextPath + "/configuration/{id}");

		ResponseEntity<Configuration> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity,
				Configuration.class);

		Assert.assertEquals("Response code from testDeleteConfigurationById_Success() is  404", 404, response.getStatusCodeValue());
	}
}
