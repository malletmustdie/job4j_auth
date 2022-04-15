package ru.job4j.auth.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.model.Report;
import ru.job4j.auth.util.ApiPathConstants;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportsController {

    private final RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody Person person) {
        restTemplate.postForObject(ApiPathConstants.REPORT_API_CREATE_PERSON, person, Person.class);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        restTemplate.put(ApiPathConstants.REPORT_API_UPDATE_PERSON, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        restTemplate.delete(ApiPathConstants.REPORT_API_DELETE_PERSON, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public List<Report> findAll() {
        List<Report> rsl = new ArrayList<>();
        List<Person> persons = restTemplate.exchange(
                ApiPathConstants.REPORT_API_FIND_ALL_PERSONS,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {

                }
        ).getBody();
        for (Person person : persons) {
            Report report = Report.builder()
                                  .id(1)
                                  .name("First")
                                  .person(person)
                                  .build();
            rsl.add(report);
        }
        return rsl;
    }

}