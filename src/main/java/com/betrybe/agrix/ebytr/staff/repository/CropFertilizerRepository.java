package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.CropFertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Crop Fertilizer repository.
 */
@Repository
public interface CropFertilizerRepository extends JpaRepository<CropFertilizer, Long> {

}
