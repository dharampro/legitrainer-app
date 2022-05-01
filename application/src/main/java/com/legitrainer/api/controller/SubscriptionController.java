package com.legitrainer.api.controller;

import com.legitrainer.api.constant.ApiEndPoint;
import com.legitrainer.api.dto.SubscriptionDto;
import com.legitrainer.api.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndPoint.SUBSCRIPTION_ROOT)
public class SubscriptionController {

  @Autowired
  private SubscriptionService subscriptionService;

  @PostMapping
  public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
    return ResponseEntity.ok().body(subscriptionService.createSubscription(subscriptionDto));
  }

  @GetMapping(ApiEndPoint.SUBSCRIPTION_ID)
  public ResponseEntity<SubscriptionDto> getSubscription(@PathVariable String subscriptionId) {
    return ResponseEntity.ok().body(subscriptionService.getSubscription(subscriptionId));
  }

  @PutMapping(ApiEndPoint.SUBSCRIPTION_ID)
  public ResponseEntity<SubscriptionDto> updateSubscription(@RequestBody SubscriptionDto subscriptionDto,
      @PathVariable String subscriptionId) {
    return ResponseEntity.ok().body(subscriptionService.updateSubscription(subscriptionDto, subscriptionId));
  }

  @DeleteMapping(ApiEndPoint.SUBSCRIPTION_ID)
  public ResponseEntity deleteSubscription(@PathVariable String subscriptionId) {
    subscriptionService.deleteSubscription(subscriptionId);
    return ResponseEntity.ok().build();
  }
}
