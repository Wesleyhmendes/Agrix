package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.CropFertilizer;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {
  public final CropService cropService;

  /**
   * Crop constructor.
   */
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * get all crops.
   */
  @GetMapping
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.findAll();

    return crops.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * get farm data by crop id.
   */
  @GetMapping("/{id}")
  public CropDto farmData(@PathVariable Long id) throws CropNotFoundException {
    Crop crop = cropService.findById(id);
    return CropDto.fromEntity(crop);
  }

  /**
   * Search crop by date.
   */
  @GetMapping("/search")
  public List<CropDto> searchCropsByDate(@RequestParam String start, String end) {
    LocalDate startParse = LocalDate.parse(start);
    LocalDate endParse = LocalDate.parse(end).plusDays(1);

    List<Crop> crops = cropService.findByDate(startParse, endParse);
    return crops.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * Faz requisição para o service com os parametros e, se nao retornar nada (sucesso),
   * retorna mensagem, senão retorna o erro do service.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateCropWithFertilizer(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    try {
      cropService.associateCropWithFertilizer(cropId, fertilizerId);
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body("Fertilizante e plantação associados com sucesso!");
    } catch (CropNotFoundException | FertilizerNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  /**
   * Get fertilizer by crop id.
   */
  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getFertilizerByCropId(@PathVariable Long cropId)
      throws CropNotFoundException {
    List<CropFertilizer> cropFertilizers = cropService.findById(cropId).getCropFertilizers();
    List<Fertilizer> fertilizers = cropFertilizers
        .stream().map(CropFertilizer::getFertilizer).toList();

    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }
}
