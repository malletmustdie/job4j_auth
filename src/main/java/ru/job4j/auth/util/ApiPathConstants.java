package ru.job4j.auth.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiPathConstants {

    public static final String API_V_1 = "/api/v1";

    public static final String PERSON = "/person";

    public static final String CREATE_PERSON = "/create-person";

    public static final String UPDATE_PERSON = "/update-person";

    public static final String DELETE_PERSON = "/delete-person";

    public static final String FIND_PERSON = "/get-person";

    public static final String FIND_ALL_PERSONS = "/get-all-persons";

    public static final String BY_ID = "/{id}";


}
