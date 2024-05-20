package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.CropFertilizer;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropFertilizerRepository;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crop service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;
  private final FertilizerRepository fertilizerRepository;

  private final CropFertilizerRepository cropFertilizerRepository;

  /**
   * CropService constructor.
   */
  @Autowired
  public CropService(
      CropRepository cropRepository,
      FarmRepository farmRepository,
      FertilizerRepository fertilizerRepository,
      CropFertilizerRepository cropFertilizerRepository
  ) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
    this.fertilizerRepository = fertilizerRepository;
    this.cropFertilizerRepository = cropFertilizerRepository;
  }

  /**
   * create crop.
   */
  public Crop create(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  /**
   * Search crop by date.
   */
  public List<Crop> findByDate(LocalDate start, LocalDate end) {
    List<Crop> allCrops = cropRepository.findAll();
    return allCrops.stream()
        .filter(crop -> !crop.getHarvestDate()
            .isBefore(start) && !crop.getHarvestDate()
            .isAfter(end)).toList();
  }

  /**
   * Busca o crop e o fertilizer, cria uma instancia,
   * setta o corp e o fertilizer e adiciona o cropFertilizer, depois salva tudo.
   */
  @Transactional
  public void associateCropWithFertilizer(
      Long cropId,
      Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = cropRepository.findById(cropId).orElseThrow(CropNotFoundException::new);

    Fertilizer fertilizer = fertilizerRepository
        .findById(fertilizerId).orElseThrow(FertilizerNotFoundException::new);

    CropFertilizer cropFertilizer = new CropFertilizer();
    cropFertilizer.setCrop(crop);
    cropFertilizer.setFertilizer(fertilizer);

    cropFertilizerRepository.save(cropFertilizer);
  }

  public List<CropFertilizer> getFertilizerByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = findById(cropId);
    return crop.getCropFertilizers();
  }

}
