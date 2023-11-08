package com.acms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.acms.entity.ConfigurationEntity;
import com.acms.entity.ConfigurationValueEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called ConfigurationRepository
// CRUD refers Create, Read, Update, Delete

public interface ConfigurationValueRepository extends CrudRepository<ConfigurationValueEntity, Integer> {

	Optional<ConfigurationValueEntity> findById(Integer id);

}