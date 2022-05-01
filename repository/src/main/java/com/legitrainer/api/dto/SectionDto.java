package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionDto {
  private String title;
  private String description;
  private String videoUrl;
  private String notesUrl;
}
