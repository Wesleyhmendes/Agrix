package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Farm not found exception.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
