package com.fatih.app.core.common.model;
import lombok.Data;

public class EmployeeInfo extends BaseInfo {
    private String location;
    private double prize;
    private String name;
    private String surname;
    private String department;
    
    public String getName() {
    	return name;
    }
    
    public void setName(String n) {
    	name = n;
    }
    
    public String getSurname() {
    	return surname;
    }
    
    public void setSurname(String n) {
    	surname = n;
    }
    
    public double getPrize() {
    	return prize;
    }
    
    public void setPrize(double n) {
    	prize = n;
    }
    
    public String getLocation() {
    	return location;
    }
    
    public void setLocation(String n) {
    	location = n;
    }
    
    public String getDepartment() {
    	return department;
    }
    
    public void setDepartment(String n) {
    	department = n;
    }
}
