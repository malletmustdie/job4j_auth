package ru.job4j.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.auth.config.SpringMapperConfig;
import ru.job4j.auth.model.Employee;
import ru.job4j.auth.model.dto.EmployeeDto;
import ru.job4j.auth.model.dto.EmployeeInfo;

@Mapper(config = SpringMapperConfig.class)
public interface EmployeeMapper {

    @Mapping(source = "dto.id", target = "id")
    @Mapping(source = "dto.firstname", target = "firstname")
    @Mapping(source = "dto.lastname", target = "lastname")
    @Mapping(source = "dto.itn", target = "itn")
    @Mapping(source = "dto.hiringDate", target = "hiringDate")
    @Mapping(source = "dto.accounts", target = "accounts")
    Employee map(EmployeeDto dto);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.firstname", target = "firstname")
    @Mapping(source = "entity.lastname", target = "lastname")
    @Mapping(source = "entity.itn", target = "itn")
    @Mapping(source = "entity.hiringDate", target = "hiringDate")
    @Mapping(source = "entity.accounts", target = "accounts")
    EmployeeDto map(Employee entity);

    @Mapping(source = "entity.firstname", target = "firstname")
    @Mapping(source = "entity.lastname", target = "lastname")
    @Mapping(source = "entity.itn", target = "itn")
    @Mapping(source = "entity.hiringDate", target = "hiringDate")
    @Mapping(source = "entity.accounts", target = "accounts")
    EmployeeInfo mapToEmployeeInfo(Employee entity);

}
