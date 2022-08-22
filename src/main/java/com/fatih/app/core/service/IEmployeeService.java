package com.fatih.app.core.service;

import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.Employee;

import java.util.Date;
import java.util.List;

public interface IEmployeeService extends IBaseService<Employee, EmployeeInfo> {

    Employee getByEmployeename(String username) throws AppServiceException;
    public List<Employee> getByDateAndIncome(Date d, double income) throws AppServiceException;
}
