package com.ifour.payrollservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table
public class Payroll {

    @Id
    private int employeeId;
    private int allowance;     //HRA + others
    private int deduction;     //ESI + TDS + Tax + PF
    public int net_salary;
    public int salary;
    private int unpaidLeaves;
    private int paidLeaves;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Payroll() {
    }

    public Payroll(int employeeId,int salary, int allowance, int deduction, int net_salary,int unpaidLeaves,int paidLeaves) {
        this.allowance = allowance;
        this.salary = salary;
        this.deduction = deduction;
        this.net_salary = net_salary;
        this.employeeId = employeeId;
        this.paidLeaves = paidLeaves;
        this.unpaidLeaves = unpaidLeaves;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getDeduction() {
        return unpaidLeaves*(salary/Calendar.DAY_OF_MONTH);
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getNet_salary() {
        return salary-deduction-allowance;
    }

    public void setNet_salary(int net_salary) {
        this.net_salary = net_salary;
    }


    @Override
    public String toString() {
        return "Payroll{" +"employeeId"+ employeeId +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", net_salary=" + net_salary +
                ",salary="+salary+
                ",unpaid leaves = " +unpaidLeaves+
                ",paid leaves = " +paidLeaves+
                '}';
    }

}


