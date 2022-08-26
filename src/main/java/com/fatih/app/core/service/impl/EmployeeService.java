package com.fatih.app.core.service.impl;

import com.fatih.app.core.common.model.EmployeeChoosenDateAndIncomeRequest;
import com.fatih.app.core.common.model.EmployeeInfo;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.BaseEntity;
import com.fatih.app.core.persist.Employee;
import com.fatih.app.core.repo.EmployeeRepository;
import com.fatih.app.core.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EmployeeService extends BaseService<Employee, EmployeeInfo> implements IEmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public EmployeeRepository getRepo() {
        return repo;
    }

    @PostConstruct
    public void init() throws AppServiceException {
        /*First user*/

        List<Employee> system = getRepo().findByName("System");
        if (system == null || system.isEmpty()) {
            EmployeeInfo i = new EmployeeInfo();
            i.setName("System");
            i.setSurname("Employee");
        }
    }

    @Override
    public Employee getEntity(EmployeeInfo info) {
        Employee entity;
        if (info.getId() == null) {
            entity = new Employee();
        } else {
            entity = getRepo().findById(info.getId()).get();
        }

        return entity;
    }

    @Override
    public Employee prepareForCreate(EmployeeInfo info) throws AppServiceException {
        validateFields(info);

        List<Employee> list = getRepo().findByName(info.getName());

        if (!list.isEmpty()) {
            throw new AppServiceException("There is already a username as " + info.getName());
        }

        Employee entity = new Employee();
        entity.fromInfo(info);
        return entity;
    }

    @Override
    public Employee prepareForUpdate(EmployeeInfo info) throws AppServiceException {
        validateFields(info);

        if (info.getId() == null) {
            throw new AppServiceException("Employee cannot be found. Because there is no id ");
        }

        Employee entity = getRepo().findById(info.getId()).get();

        if (entity == null) {
            throw new AppServiceException("There is no a user with id " + info.getId());
        }

        entity.fromInfo(info);
        return entity;
    }

    @Override
    public void prepareForDelete(Long id) throws AppServiceException {

        if (id == null) {
            throw new AppServiceException("Employee cannot be found. Because there is no id ");
        }

        Employee entity = getRepo().findById(id).get();

        if (entity == null) {
            throw new AppServiceException("There is no user with id " + id);
        }
    }

    private void validateFields(EmployeeInfo info) throws AppServiceException {
        if (!StringUtils.hasLength(info.getName())) {
            throw new AppServiceException("Name is required!");
        }

        if (!StringUtils.hasLength(info.getSurname())) {
            throw new AppServiceException("Surname is required!");
        }
    }

    @Override
    public EmployeeInfo getByEmployeeName(String username) throws AppServiceException {
        return getRepo().findByName(username).stream().findFirst().map(BaseEntity::toInfo).orElse(null);
    }

    public List<EmployeeInfo> getEmployeeByDateAndIncome(EmployeeChoosenDateAndIncomeRequest dto) throws AppServiceException {
        return getRepo().findByChoosenDateAfterAndIncomeGreaterThan(dto.getChoosenDate(), dto.getIncome())
                .stream()
                .map(BaseEntity::toInfo)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateLocation(String department, String location) throws AppServiceException {
        try {
            List<Employee> list = getRepo().findByDepartment(department);

            for (Employee e : list) {
                e.setLocation(location);
                getRepo().save(e);
            }
            log.info("Location updated for department " + department);
            return true;
        } catch (Exception e) {
            log.error("Error while updating location", e);
            throw new AppServiceException(e);
        }
    }
}
