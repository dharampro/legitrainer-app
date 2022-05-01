package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
  private String userId;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private AddressDto address;
}
