package com.legitrainer.api.repository;

import com.legitrainer.api.entity.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findByUserId(String userId);

  @DeleteQuery
  void deleteByUserId(String userId);
}
