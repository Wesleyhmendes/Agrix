package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;
import java.time.LocalDate;

/**
 * Creation crop dto.
 */
public record PersonCreationDto(
    String username, String password, Role role
) {
  public Person toEntity() {
    return new Person(username, password, role);
  }
}
