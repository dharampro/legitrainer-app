package com.legitrainer.api.service;

import com.legitrainer.api.dto.SubscriptionDto;

public interface SubscriptionService {
  SubscriptionDto createSubscription(SubscriptionDto subscriptionDto);

  SubscriptionDto getSubscription(String subscriptionId);

  SubscriptionDto updateSubscription(SubscriptionDto subscriptionDto, String subscriptionId);

  void deleteSubscription(String subscriptionId);
}
