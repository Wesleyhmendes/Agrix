package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import java.time.LocalDate;

/**
 * Creation crop dto.
 */
public record CropCreationDto(
    Long farmId, String name, double plantedArea, LocalDate plantedDate, LocalDate harvestDate
) {
  public Crop toEntity() {
    return new Crop(new Farm(farmId), name, plantedArea, plantedDate, harvestDate);
  }
}


