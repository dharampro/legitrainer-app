package com.legitrainer.api.exception;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String msg) {
    super(msg);
  }
}
