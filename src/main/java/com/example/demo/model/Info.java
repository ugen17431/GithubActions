package com.example.demo.model;

public class Info {
    private int id;
    private String empName;
    private String companyName;
    private double salary;

    public Info() {
    }

    public Info(int id, String empName, String companyName, double salary) {
        this.id = id;
        this.empName = empName;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
