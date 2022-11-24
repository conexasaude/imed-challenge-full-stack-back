package com.conexasaude.exceptions;

public class ImedApplicationException extends RuntimeException {

  public ImedApplicationException() {
    super();
  }

  public ImedApplicationException(String message) {
    super(message);
  }

  public ImedApplicationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ImedApplicationException(Throwable cause) {
    super(cause);
  }

  protected ImedApplicationException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
