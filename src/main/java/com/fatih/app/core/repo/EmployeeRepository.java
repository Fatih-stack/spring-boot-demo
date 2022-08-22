
package com.fatih.app.core.repo;

import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.persist.Employee;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee, EmployeeInfo> {

    List<Employee> findByName(String name);
    List<Employee> findBySurname(String surname);
 //   List<Employee> findByEmployees();
    List<Employee> findByLocation(String loc);
    List<Employee> findByDepartment(String dep);
    List<Employee> findByCreatedDateAndIncome(Date date, double income);
  //  List<Employee> findByDate(Date d);
  //  List<Employee> findByDateAndIncome(Date date, double income);
}
