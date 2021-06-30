package com.ifour.departmentservice;

import javax.persistence.*;

@Entity
@Table
public class Department {
    @Id
    private Integer deptId;
    private String deptName;
    private int employeeId;

    public Department(Integer deptId, String deptName, int employeeId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        employeeId = employeeId;
    }
//@JoinColumn(name = "id",updatable = false,insertable = false)
    //@NotFound(action = NotFoundAction.EXCEPTION)
    //@ManyToOne
    //@JoinColumn(name = "dept_id",updatable = false,insertable = false)
    //private Employee employee;


    public Department() {
    }

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(int id, String name, int salary) {
    }


    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

}




