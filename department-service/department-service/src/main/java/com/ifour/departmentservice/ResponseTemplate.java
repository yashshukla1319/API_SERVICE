package com.ifour.departmentservice;

public class ResponseTemplate {
    public Employee employee;
    public Department department;
    public Payroll payroll;

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ResponseTemplate(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }

    public ResponseTemplate(Department department, Payroll payroll) {
        this.department = department;
        this.payroll = payroll;
    }

    public ResponseTemplate() {
    }

    @Override
    public String toString() {
        return "ResponseTemplate{" +
                "employee=" + employee +
                ", department=" + department +
                '}';
    }
}
