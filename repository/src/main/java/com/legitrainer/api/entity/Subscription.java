package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = ModelConstant.SUBSCRIPTION_COLLECTION)
public class Subscription {
  @Id
  private String id;
  private String subscriptionId;
  private String courseId;
  private String userId;
}
