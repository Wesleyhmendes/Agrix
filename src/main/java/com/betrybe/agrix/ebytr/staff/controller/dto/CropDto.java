package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * crop dto.
 */
public record CropDto(
    Long id,
    String name,
    double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate
) {

  /**
   * Crop dto.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }
}

