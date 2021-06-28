package com.ifour.departmentservice;

import javax.persistence.*;

@Entity
@Table
public class Department {
    @Id

    @SequenceGenerator(name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )

    //@Id
    private Integer dept_id;
    private String dept_name;
    @JoinColumn(name = "id",updatable = false,insertable = false)
    private int id;
    //@NotFound(action = NotFoundAction.EXCEPTION)
    //@ManyToOne
    //@JoinColumn(name = "dept_id",updatable = false,insertable = false)
    //private Employee employee;


    public Department() {
    }

    public Department(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }

    public Department(String dept_name) {
        this.dept_name = dept_name;
    }

    public Department(int id, String name, int salary) {
    }


    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }

}




