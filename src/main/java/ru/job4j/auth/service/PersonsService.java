package ru.job4j.auth.service;

import java.util.List;
import java.util.Optional;

import ru.job4j.auth.model.Person;
import ru.job4j.auth.model.dto.PersonDto;

public interface PersonsService {

    Person save(PersonDto dto);

    void update(PersonDto dto);

    void delete(Long id);

    Optional<PersonDto> findById(Long id);

    List<Person> findAll();

}
