package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ContentDto {
  private String title;
  private String description;
  private Set<SectionDto> sections;
}
