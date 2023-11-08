package com.acms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.acms.entity.ConfigurationEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called ConfigurationRepository
// CRUD refers Create, Read, Update, Delete

public interface ConfigurationRepository extends CrudRepository<ConfigurationEntity, Integer> {

	Optional<ConfigurationEntity> findById(Integer id);

}