package com.fatih.app.core.ws;

import com.fatih.app.core.common.model.EmployeeChoosenDateAndIncomeRequest;
import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.common.ws.ServiceUri;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.Employee;
import com.fatih.app.core.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ServiceUri.EMPLOYEE)
public class EmployeeController extends BaseController<Employee, EmployeeInfo, IEmployeeService> {

    @Autowired
    private IEmployeeService service;

    @Override
    public IEmployeeService getService() {
        return service;
    }

    @PostMapping(ServiceUri.DATE_AND_INCOME)
    public List<EmployeeInfo> getByDateAndIncome(@RequestBody EmployeeChoosenDateAndIncomeRequest dto) throws AppServiceException {
        return service.getEmployeeByDateAndIncome(dto);
    }

    @GetMapping(ServiceUri.UPDATE_LOCATION)
    public Boolean updateLocation(@PathVariable String department, @PathVariable String location) throws AppServiceException {
        return service.updateLocation(department,location);
    }
}
