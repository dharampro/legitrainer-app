package com.legitrainer.api.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Content {
  private String title;
  private String description;
  private Set<Section> sections;
}
