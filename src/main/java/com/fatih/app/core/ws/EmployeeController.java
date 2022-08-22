package com.fatih.app.core.ws;

import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.common.ws.ServiceUri;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.Employee;
import com.fatih.app.core.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ServiceUri.EMPLOYEE)
public class EmployeeController extends BaseController<Employee, EmployeeInfo, IEmployeeService> {

    @Autowired
    private IEmployeeService service;

    @Override
    public IEmployeeService getService() {
        return service;
    }
    
    @PostMapping(ServiceUri.DATE_AND_INCOME)
    public EmployeeInfo getByDateAndIncome(@RequestBody EmployeeInfo Body) 
    {
    	
    }
}
