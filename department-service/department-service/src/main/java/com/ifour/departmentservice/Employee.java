package com.ifour.departmentservice;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private int deptId;

    public Employee() {
    }

    public Employee(int id, String name, int salary,int deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Employee(String name, int salary, int deptId) {
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public  int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}

