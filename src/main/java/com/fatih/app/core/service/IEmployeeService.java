package com.fatih.app.core.service;

import com.fatih.app.core.common.model.EmployeeChoosenDateAndIncomeRequest;
import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IEmployeeService extends IBaseService<Employee, EmployeeInfo> {

    EmployeeInfo getByEmployeeName(String username) throws AppServiceException;

    List<EmployeeInfo> getEmployeeByDateAndIncome(EmployeeChoosenDateAndIncomeRequest dto) throws AppServiceException;

    Boolean updateLocation(String department, String location) throws AppServiceException;
}
