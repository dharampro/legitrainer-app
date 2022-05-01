package com.legitrainer.api.entity;

import com.legitrainer.api.constant.ModelConstant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = ModelConstant.USER_COLLECTION)
public class User {

  @Id
  private String id;

  @Indexed(unique = true)
  private String userId;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String email;

  @NotBlank
  private String phone;

  private Address address;
}
