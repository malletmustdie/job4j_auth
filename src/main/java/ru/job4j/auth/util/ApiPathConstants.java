package ru.job4j.auth.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiPathConstants {

    public static final String URL = "http://localhost:8080/";

    public static final String API_V_1 = "/api/v1";

    public static final String BY_ID = "/{id}";

    public static final String PERSON = "/person";

    public static final String CREATE_PERSON = "/create-person";

    public static final String UPDATE_PERSON = "/update-person";

    public static final String DELETE_PERSON = "/delete-person";

    public static final String FIND_PERSON = "/get-person";

    public static final String FIND_ALL_PERSONS = "/get-all-persons";

    public static final String EMPLOYEE = "/employee";

    public static final String CREATE_EMPLOYEE = "/create-employee";

    public static final String UPDATE_EMPLOYEE = "/update-employee";

    public static final String DELETE_EMPLOYEE = "/delete-employee";

    public static final String FIND_EMPLOYEE = "/get-employee";

    public static final String FIND_ALL_EMPLOYEES = "/get-all-employees";

    public static final String REPORT_API_CREATE_PERSON = URL + API_V_1 + PERSON + UPDATE_PERSON;

    public static final String REPORT_API_UPDATE_PERSON = URL + API_V_1 + PERSON + UPDATE_PERSON;

    public static final String REPORT_API_DELETE_PERSON = URL + API_V_1 + PERSON + UPDATE_PERSON;

    public static final String REPORT_API_FIND_ALL_PERSONS
            = URL + API_V_1 + PERSON + FIND_ALL_PERSONS;

}
