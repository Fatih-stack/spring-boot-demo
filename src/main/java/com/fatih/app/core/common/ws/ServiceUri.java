package com.fatih.app.core.common.ws;

public class ServiceUri {
    public static final String ID_PARAM = "/{id}";
    public static final String MSG_PARAM = "/{msg}";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String LIST = "/list";

    public static final String DELETE_ID = DELETE + ID_PARAM;
    public static final String LIST_ID = LIST + ID_PARAM;

    public static final String EMPLOYEE = "/employee";
    public static final String DATE_AND_INCOME = "/date-income";
    public static final String UPDATE_LOCATION = "/update-location/{department}/{location}";
    public static final String RANDOM_EMPLOYEE = "/random-employee";
}
