package com.ifour.payrollservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
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

    public Optional<Payroll> getPayrollByE_id(Integer e_id) {
        return payrollRepository.findById(e_id);
    }

    public void addPayroll(Payroll payroll) {

        payrollRepository.save(payroll);
    }

    public void deletePayroll(Integer e_id) {
        boolean exist = payrollRepository.existsById(e_id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists");
        }
        payrollRepository.deleteById(e_id);
    }
    @Transactional
    public void updatePayroll(Integer e_id, Integer basic, Integer allowance, Integer deduction, Integer net_salary) {
        Payroll payroll = payrollRepository.findById(e_id).orElseThrow(()->new IllegalStateException("Employee with Id"+e_id+"is not present"));

        if(!Objects.equals(payroll.getBasic(),basic))
        {
            payroll.setBasic(basic);
        }

        if(!Objects.equals(payroll.getAllowance(),allowance))
        {
            payroll.setAllowance(allowance);
        }

        if(!Objects.equals(payroll.getDeduction(),deduction))
        {
            payroll.setDeduction(deduction);
        }

        payrollRepository.save(payroll);
    }


}
