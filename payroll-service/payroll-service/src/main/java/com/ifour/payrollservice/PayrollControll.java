package com.ifour.payrollservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
public class PayrollControll {

    @Autowired
    public PayrollService payrollService;

    @RequestMapping(path = "/get")
    public List<Payroll> getPayroll()
    {
        return payrollService.getPayroll();
    }

    @RequestMapping(path = "/get/{E_id}")
    public Optional<Payroll> getPayrollByE_id(@PathVariable("E_id") Integer E_id)
    {
        return payrollService.getPayrollByE_id(E_id);
    }
    @RequestMapping(path="/add", method = RequestMethod.POST)
    public void addPayroll(@RequestBody Payroll payroll)
    {
        payrollService.addPayroll(payroll);
    }

    @RequestMapping(path = "/delete/{E_id}", method = RequestMethod.DELETE)
    public void deletePayroll(@PathVariable("E_id")Integer E_id)
    {
        payrollService.deletePayroll(E_id);
    }


    @RequestMapping(path = "/update/{E_id}", method = RequestMethod.PUT)
    public void updatePayroll(@PathVariable("E_id") Integer E_id,
                              @RequestParam(required = false)Integer basic,
                              @RequestParam(required = false)Integer allowance,
                              @RequestParam(required = false)Integer deduction,
                              @RequestParam(required = false)Integer net_salary)
    {
        payrollService.updatePayroll(E_id,basic,allowance,deduction,net_salary);
    }

}


