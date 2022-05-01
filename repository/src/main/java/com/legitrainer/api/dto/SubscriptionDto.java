package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionDto {
  private String subscriptionId;
  private Boolean isActive;
  private String courseId;
  private String userId;
}
