package com.legitrainer.api.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Module {
  private String title;
  private String description;
  private Set<Content> contents;
}
