package com.legitrainer.api.entity;

import lombok.Data;

@Data
public class Address {
  private String address;
  private String city;
  private String state;
  private String country;
  private Integer pin;
}
