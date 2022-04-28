package com.legitrainer.api.exception;

import com.legitrainer.api.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ BadRequestException.class, HttpClientErrorException.BadRequest.class })
  public ResponseEntity<ErrorDto> applicationException(BadRequestException ex, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorDto.builder().error(ex.getMessage()).url(request.getRequestURI()).time(LocalDateTime.now()).build());
  }

  @ExceptionHandler({ ResourceNotFoundException.class, HttpClientErrorException.NotFound.class })
  public ResponseEntity<ErrorDto> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorDto.builder().error(ex.getMessage()).url(request.getRequestURI()).time(LocalDateTime.now()).build());
  }

  @ExceptionHandler({ ResourceNotModifiedException.class, HttpClientErrorException.Conflict.class })
  public ResponseEntity<ErrorDto> ambiguousException(ResourceNotModifiedException ex, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(ErrorDto.builder().error(ex.getMessage()).url(request.getRequestURI()).time(LocalDateTime.now()).build());
  }

  @ExceptionHandler({ Exception.class, HttpServerErrorException.InternalServerError.class })
  public ResponseEntity<ErrorDto> exception(Exception ex, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorDto.builder().error(ex.getMessage()).url(request.getRequestURI()).time(LocalDateTime.now()).build());
  }
}
