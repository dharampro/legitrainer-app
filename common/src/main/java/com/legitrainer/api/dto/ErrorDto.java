package com.legitrainer.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDto {
  private String url;
  private String error;
  private LocalDateTime time;
}
