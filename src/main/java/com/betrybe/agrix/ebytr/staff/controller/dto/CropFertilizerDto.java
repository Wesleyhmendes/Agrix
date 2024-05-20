package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.CropFertilizer;

/**
 * Crop fertilizer Dto.
 */
public record CropFertilizerDto(
    Long id,
    Long fertilizerId,
    Long cropId
) {

  /**
   * CropFertilizerDto Dto.
   *
   */
  public static CropFertilizerDto fromEntity(CropFertilizer cropFertilizer) {
    return new CropFertilizerDto(
        cropFertilizer.getId(),
        cropFertilizer.getFertilizer().getId(),
        cropFertilizer.getCrop().getId()
    );
  }
}

