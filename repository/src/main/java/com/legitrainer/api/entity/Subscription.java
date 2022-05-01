package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = ModelConstant.SUBSCRIPTION_COLLECTION)
public class Subscription {
  @Id
  private String id;

  @Indexed(unique = true)
  private String subscriptionId;

  private Boolean isActive;
  private String courseId;
  private String userId;
}
