package ru.job4j.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.auth.config.SpringMapperConfig;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.model.dto.PersonDto;

@Mapper(config = SpringMapperConfig.class)
public interface PersonMapper {

    @Mapping(source = "dto.id", target = "id")
    @Mapping(source = "dto.login", target = "login")
    @Mapping(source = "dto.password", target = "password")
    Person map(PersonDto dto);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.login", target = "login")
    @Mapping(source = "entity.password", target = "password")
    PersonDto map(Person entity);

}
