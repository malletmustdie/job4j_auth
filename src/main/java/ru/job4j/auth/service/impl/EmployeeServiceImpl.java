package ru.job4j.auth.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.auth.mapper.EmployeeMapper;
import ru.job4j.auth.model.Employee;
import ru.job4j.auth.model.dto.EmployeeDto;
import ru.job4j.auth.model.dto.EmployeeInfo;
import ru.job4j.auth.repository.EmployeeRepository;
import ru.job4j.auth.service.EmployeeService;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public Employee save(EmployeeDto dto) {
        var employee = employeeMapper.map(dto);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void update(EmployeeDto dto) {
        var emp = employeeMapper.map(dto);
        employeeRepository.findById(emp.getId())
                          .ifPresent(employee -> {
                              employee.setFirstname(emp.getFirstname());
                              employee.setLastname(emp.getLastname());
                              employee.setItn(emp.getItn());
                              employee.setHiringDate(emp.getHiringDate());
                              emp.getAccounts().forEach(employee::addAccount);
                              employeeRepository.save(employee);
                          });
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<EmployeeInfo> findEmployeeById(Long id) {
        return Optional.of(
                employeeMapper.mapToEmployeeInfo(employeeRepository.getById(id))
        );
    }

    @Override
    public List<EmployeeInfo> findAllEmployeeInfo() {
        return employeeRepository.findAllEmployeesWithAccounts()
                                 .stream()
                                 .map(employeeMapper::mapToEmployeeInfo)
                                 .collect(Collectors.toList());
    }

}
