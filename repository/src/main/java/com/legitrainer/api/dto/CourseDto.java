package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CourseDto {
  private String courseId;
  private String title;
  private Integer length;
  private String thumbnail;
  private Set<String> moduleIds;
}
