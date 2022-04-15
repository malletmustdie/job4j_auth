package ru.job4j.auth.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private int id;

    private String name;

    @Builder.Default
    private LocalDate created = LocalDate.now();

    private Person person;

}
