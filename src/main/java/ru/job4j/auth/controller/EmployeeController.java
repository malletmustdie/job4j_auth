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
import ru.job4j.auth.model.Employee;
import ru.job4j.auth.model.dto.EmployeeDto;
import ru.job4j.auth.model.dto.EmployeeInfo;
import ru.job4j.auth.service.EmployeeService;
import ru.job4j.auth.util.ApiPathConstants;

@RequiredArgsConstructor
@Api(tags = "Эндпоинты для управления сущностью Employee")
@RequestMapping(ApiPathConstants.API_V_1 + ApiPathConstants.EMPLOYEE)
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @ApiOperation("Создание сущности Employee")
    @PostMapping(value = ApiPathConstants.CREATE_EMPLOYEE, produces = "application/json")
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(employeeService.save(dto), HttpStatus.CREATED);
    }

    @ApiOperation("Редактирование сущности Employee")
    @PutMapping(value = ApiPathConstants.UPDATE_EMPLOYEE, produces = "application/json")
    public ResponseEntity<Void> update(@RequestBody EmployeeDto dto) {
        employeeService.update(dto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Удаление сущности Employee")
    @DeleteMapping(value = ApiPathConstants.DELETE_EMPLOYEE + ApiPathConstants.BY_ID,
                   produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Получение полной информации об Employee")
    @GetMapping(value = ApiPathConstants.FIND_EMPLOYEE + ApiPathConstants.BY_ID,
                produces = "application/json")
    public ResponseEntity<EmployeeInfo> findEmployeeInfoById(@PathVariable Long id) {
        var empInfo = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(
                empInfo.orElse(new EmployeeInfo()),
                empInfo.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @ApiOperation("Получение списка полной информации об Employee")
    @GetMapping(value = ApiPathConstants.FIND_ALL_EMPLOYEES, produces = "application/json")
    public List<EmployeeInfo> findAllEmployeeInfo() {
        return employeeService.findAllEmployeeInfo();
    }

}
