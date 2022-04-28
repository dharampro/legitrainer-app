package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
  private String address;
  private String city;
  private String state;
  private String country;
  private Integer pin;
}
