package com.gl.dbmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String employeeName;
    private String employeeAddress;
    private int employeePhone;
    private double employeeSalary;

    public Employee() 
    {
    	
    }

    public Employee(int id, String employeeName, String employeeAddress, int employeePhone, double employeeSalary) 
    {
        super();
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
    }
    

    public Employee( String employeeName, String employeeAddress, int employeePhone, double employeeSalary) 
    {
        super();
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(int employeePhone) {
        this.employeePhone = employeePhone;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
