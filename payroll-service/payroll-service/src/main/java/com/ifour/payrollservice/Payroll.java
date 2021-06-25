package com.ifour.payrollservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Payroll {

    @Id
    private int E_id;
    private int basic;         //Basic
    private int allowance;     //HRA + others
    private int deduction;     //ESI + TDS + Tax + PF
    private int net_salary;

    public Payroll() {
    }

    public Payroll(int E_id,int basic, int allowance, int deduction, int net_salary) {
        this.basic = basic;
        this.allowance = allowance;
        this.deduction = deduction;
        this.net_salary = net_salary;
        this.E_id = E_id;
    }

    public int getE_id()
    {
        return E_id;
    }
    public void setE_id(int E_id)
    {
        this.E_id = E_id;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(int net_salary) {
        this.net_salary = net_salary;
    }


    @Override
    public String toString() {
        return "Payroll{" +"E_id"+ E_id +
                "basic=" + basic +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", net_salary=" + net_salary +
                '}';
    }

}


