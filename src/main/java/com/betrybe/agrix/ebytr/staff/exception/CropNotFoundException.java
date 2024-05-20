package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Crop not found exception.
 */
public class CropNotFoundException extends NotFoundException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
