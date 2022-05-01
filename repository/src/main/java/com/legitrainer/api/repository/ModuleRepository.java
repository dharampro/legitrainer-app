package com.legitrainer.api.repository;

import com.legitrainer.api.entity.Module;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, String> {

  Module findByModuleId(String moduleId);

  @DeleteQuery
  void deleteByModuleId(String moduleId);
}
