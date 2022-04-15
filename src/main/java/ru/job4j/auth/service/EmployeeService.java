package ru.job4j.auth.service;

import java.util.List;
import java.util.Optional;

import ru.job4j.auth.model.Employee;
import ru.job4j.auth.model.dto.EmployeeDto;
import ru.job4j.auth.model.dto.EmployeeInfo;

public interface EmployeeService {

    Employee save(EmployeeDto dto);

    void update(EmployeeDto dto);

    void delete(Long id);

    Optional<EmployeeInfo> findEmployeeById(Long id);

    List<EmployeeInfo> findAllEmployeeInfo();

}
