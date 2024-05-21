package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fertilizer controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {
  public final FertilizerService fertilizerService;

  /**
   * Fertilizer constructor.
   */
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create Fertilizer.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto)
      throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(
        fertilizerService.create(fertilizerCreationDto.toEntity())
    );
  }

  /**
   * Find all fertilizers.
   */
  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();

    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }

  /**
   * Get fertilizer by id.
   */
  @GetMapping("/{id}")
  public FertilizerDto getFertilizerById(@PathVariable Long id) throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(
        fertilizerService.findById(id)
    );
  }
}




















