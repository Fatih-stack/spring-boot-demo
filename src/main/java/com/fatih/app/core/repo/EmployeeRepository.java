
package com.fatih.app.core.repo;

import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.persist.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee, EmployeeInfo> {

    List<Employee> findByName(String name);
    
   // EmployeeInfo findEmployeeRandom();

    List<Employee> findBySurname(String surname);

    //   List<Employee> findByEmployees();
    List<Employee> findByLocation(String loc);

    List<Employee> findByDepartment(String dep);

    List<Employee> findByChoosenDateAfterAndIncomeGreaterThan(Date choosenDate, BigDecimal income);
    //  List<Employee> findByDate(Date d);
    //  List<Employee> findByDateAndIncome(Date date, double income);
}
