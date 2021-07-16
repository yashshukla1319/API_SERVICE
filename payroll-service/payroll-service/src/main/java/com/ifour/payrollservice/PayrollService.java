package com.ifour.payrollservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    public PayrollRepository payrollRepository;

    public List<Payroll> getPayroll() {
        return payrollRepository.findAll();

    }

    public Optional<Payroll> findPayrollByEmployeeId(Integer employeeId) {
        return payrollRepository.findPayrollByEmployeeId(employeeId);
    }

    public Payroll addPayroll(Payroll payroll) {

        return payrollRepository.save(payroll);
    }

    public void deletePayroll(Integer employeeId) {
        boolean exist = payrollRepository.existsById(employeeId);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists");
        }
         payrollRepository.deleteById(employeeId);
    }
    @Transactional
    public void updatePayroll(Integer employeeId, Integer basic, Integer allowance, Integer deduction, Integer net_salary) {
        Payroll payroll = payrollRepository.findById(employeeId).orElseThrow(()->new IllegalStateException("Employee with Id"+employeeId+"is not present"));

        if(!Objects.equals(payroll.getSalary(),basic))
        {
            payroll.setSalary(basic);
        }

        if(!Objects.equals(payroll.getAllowance(),allowance))
        {
            payroll.setAllowance(allowance);
        }

        if(!Objects.equals(payroll.getDeduction(),deduction))
        {
            payroll.setDeduction(deduction);
        }
        if(!Objects.equals(payroll.getNet_salary(),net_salary))
        {
            payroll.setNet_salary(net_salary);
        }

        payrollRepository.save(payroll);
    }


    /*public Payroll findByEmployeeId(Integer E_id) {
        return payrollRepository.findByEmployeeId(E_id);
    }*/
}
