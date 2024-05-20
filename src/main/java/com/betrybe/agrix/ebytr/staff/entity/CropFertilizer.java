package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * CropFertilizer entity.
 */
@Entity
@Table(name = "crop_fertilizer")
public class CropFertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "fertilizer_id", nullable = false)
  private Fertilizer fertilizer;

  @ManyToOne
  @JoinColumn(name = "crop_id", nullable = false)
  private Crop crop;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Fertilizer getFertilizer() {
    return fertilizer;
  }

  public void setFertilizer(Fertilizer fertilizer) {
    this.fertilizer = fertilizer;
  }

  public Crop getCrop() {
    return crop;
  }

  public void setCrop(Crop crop) {
    this.crop = crop;
  }
}

