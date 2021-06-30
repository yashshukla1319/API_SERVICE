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

    @RequestMapping(path = "/get/{employeeId}")
    public Optional<Payroll> findPayrollByEmployeeId(@PathVariable("employeeId") Integer employeeId)
    {
        return payrollService.findPayrollByEmployeeId(employeeId);
    }
    @RequestMapping(path="/add", method = RequestMethod.POST)
    public void addPayroll(@RequestBody Payroll payroll)
    {
        payrollService.addPayroll(payroll);
    }

    @RequestMapping(path = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void deletePayroll(@PathVariable("employeeId")Integer employeeId)
    {
        payrollService.deletePayroll(employeeId);
    }


    @RequestMapping(path = "/update/{employeeId}", method = RequestMethod.PUT)
    public void updatePayroll(@PathVariable("employeeId") Integer employeeId,
                              @RequestParam(required = false)Integer basic,
                              @RequestParam(required = false)Integer allowance,
                              @RequestParam(required = false)Integer deduction,
                              @RequestParam(required = false)Integer net_salary)
    {
        payrollService.updatePayroll(employeeId,basic,allowance,deduction,net_salary);
    }

    /*@RequestMapping(path = "/byEmployeeId/{employeeId}")
    public Payroll findByEmployeeId(@PathVariable("employeeId") Integer employeeId){
        return payrollService.findByEmployeeId(employeeId);

    }*/

}


