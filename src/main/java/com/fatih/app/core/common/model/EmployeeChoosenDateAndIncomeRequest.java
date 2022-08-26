package com.fatih.app.core.common.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmployeeChoosenDateAndIncomeRequest {

    private Date choosenDate;
    private BigDecimal income;

}
