package com.dmx.profile.user_profile.domain;

public class AgeNotValidException extends RuntimeException {
  public AgeNotValidException(String message) {
    super(message);
  }
}
