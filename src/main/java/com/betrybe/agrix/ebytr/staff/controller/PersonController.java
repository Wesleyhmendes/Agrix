package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Person Controller.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {
  private final PersonService personService;


  /**
   * Person controller constructor.
   */
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create person.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto create(@RequestBody PersonCreationDto personCreationDto) {
    return PersonDto.fromEntity(
        personService.create(personCreationDto.toEntity())
    );
  }
}
