package com.fatih.app.core.persist;

import com.fatih.app.core.common.model.EmployeeInfo;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Employee extends BaseEntity<EmployeeInfo> {
    private String location;
    private String department;
    private String name;
    private String surname;
    private double prize;

    @Override
    public EmployeeInfo toInfo() {
    	EmployeeInfo i = new EmployeeInfo();
        i.setCreatedDate(getCreatedDate());
        i.setId(getId());
        i.setName(getName());
        i.setSurname(getSurname());
        i.setDepartment(getDepartment());
        i.setLocation(getLocation());
        i.setPrize(getPrize());
        return i;
    }

    @Override
    public void fromInfo(EmployeeInfo info) {
        setName(info.getName());
        setSurname(info.getSurname());
        setDepartment(info.getDepartment());
        setLocation(info.getLocation());
        setPrize(info.getPrize());
    }

}
