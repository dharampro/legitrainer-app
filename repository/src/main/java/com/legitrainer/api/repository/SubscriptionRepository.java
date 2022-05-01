package com.legitrainer.api.repository;

import com.legitrainer.api.entity.Subscription;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

  Subscription findBySubscriptionId(String subscriptionId);

  @DeleteQuery
  void deleteBySubscriptionId(String subscriptionId);
}
