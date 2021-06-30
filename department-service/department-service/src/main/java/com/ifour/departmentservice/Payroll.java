package com.ifour.departmentservice;

public class Payroll {
    private int employeeId;
    private int basic;         //Basic
    private int allowance;     //HRA + others
    private int deduction;     //ESI + TDS + Tax + PF
    private int net_salary;

    public Payroll() {
    }

    public Payroll(int employeeId,int basic, int allowance, int deduction, int net_salary) {
        this.basic = basic;
        this.allowance = allowance;
        this.deduction = deduction;
        this.net_salary = net_salary;
        this.employeeId = employeeId;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
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
        return "Payroll{" +"employeeId"+ employeeId +
                "basic=" + basic +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", net_salary=" + net_salary +
                '}';
    }

}


