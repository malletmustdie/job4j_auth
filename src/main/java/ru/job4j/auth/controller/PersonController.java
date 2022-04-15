package ru.job4j.auth.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.model.dto.PersonDto;
import ru.job4j.auth.service.PersonsService;
import ru.job4j.auth.util.ApiPathConstants;

@Api(tags = "Эндпоинты для управления сущностью Person")
@RestController
@RequestMapping(ApiPathConstants.API_V_1 + ApiPathConstants.PERSON)
@RequiredArgsConstructor
public class PersonController {

    private final PersonsService personsService;

    @ApiOperation("Получение списка сущностей Person")
    @GetMapping(ApiPathConstants.FIND_ALL_PERSONS)
    public List<Person> findAll() {
        return personsService.findAll();
    }

    @ApiOperation("Получение сущности Person по идентификатору")
    @GetMapping(ApiPathConstants.FIND_PERSON + ApiPathConstants.BY_ID)
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        var person = personsService.findById(id);
        return new ResponseEntity<>(
                person.orElse(new PersonDto()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @ApiOperation("Создание сущности Person")
    @PostMapping(ApiPathConstants.CREATE_PERSON)
    public ResponseEntity<Person> create(@RequestBody PersonDto person) {
        return new ResponseEntity<>(
                personsService.save(person),
                HttpStatus.CREATED
        );
    }

    @ApiOperation("Редактирование сущности Person")
    @PutMapping(ApiPathConstants.UPDATE_PERSON)
    public ResponseEntity<Void> update(@RequestBody PersonDto person) {
        personsService.update(person);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Удаление сущности Person")
    @DeleteMapping(ApiPathConstants.DELETE_PERSON + ApiPathConstants.BY_ID)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personsService.delete(id);
        return ResponseEntity.ok().build();
    }

}
