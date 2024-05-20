package com.betrybe.agrix.ebytr.staff.controller.dto;


import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Farm Dto.
 */
public record FarmDto(Long id, String name, double size) {

  /**
   * Farm dto constructor.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }
}