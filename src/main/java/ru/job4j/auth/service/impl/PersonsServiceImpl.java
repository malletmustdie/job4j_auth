package ru.job4j.auth.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.auth.mapper.PersonMapper;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.model.dto.PersonDto;
import ru.job4j.auth.repository.PersonRepository;
import ru.job4j.auth.service.PersonsService;

@RequiredArgsConstructor
@Service
@Transactional
public class PersonsServiceImpl implements PersonsService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public Person save(PersonDto dto) {
        var person = personMapper.map(dto);
        personRepository.save(person);
        return person;
    }

    @Override
    public void update(PersonDto dto) {
        var person = personMapper.map(dto);
        personRepository.findById(person.getId())
                        .ifPresent(personFromDb -> {
                            personFromDb.setLogin(person.getLogin());
                            personFromDb.setPassword(person.getPassword());
                            personRepository.save(personFromDb);
                        });
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Optional<PersonDto> findById(Long id) {
        return Optional.of(personMapper.map(personRepository.getById(id)));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

}
