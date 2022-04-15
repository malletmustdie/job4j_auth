package ru.job4j.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.job4j.auth.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select distinct e from Employee e join fetch e.accounts")
    List<Employee> findAllEmployeesWithAccounts();

}
