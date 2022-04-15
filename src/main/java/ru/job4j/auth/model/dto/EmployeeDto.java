package ru.job4j.auth.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.auth.model.Person;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    private String firstname;

    private String lastname;

    private Long itn;

    private LocalDate hiringDate;

    private List<Person> accounts;

}
