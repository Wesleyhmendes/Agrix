package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Fertilizer not found exception.
 */
public class FertilizerNotFoundException extends NotFoundException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}