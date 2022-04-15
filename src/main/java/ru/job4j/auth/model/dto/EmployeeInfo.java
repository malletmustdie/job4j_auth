package ru.job4j.auth.model.dto;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.auth.model.Person;

@ApiModel("Объект ответа со сводной информацией о сотруднике")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {

    @ApiModelProperty("Имя сотрудника")
    private String firstname;

    @ApiModelProperty("Фамилия сотрудника")
    private String lastname;

    @ApiModelProperty("Список аккаунтов сотрудника")
    private List<Person> accounts;

    @ApiModelProperty("ИНН сотрудника")
    private Long itn;

    @ApiModelProperty("Дата найма сотрудника")
    private LocalDate hiringDate;

}
