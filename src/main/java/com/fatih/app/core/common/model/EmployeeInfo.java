package com.fatih.app.core.common.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmployeeInfo extends BaseInfo {
    private String location;
    private BigDecimal prize;
    private BigDecimal income;
    private String name;
    private String surname;
    private String department;
    private Date choosenDate;
}
