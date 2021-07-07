package com.ifour.payrollservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayrollServiceTest {

    @Test
    void getPayroll() {
        String uri = "/payroll/get";
        Payroll payroll = new Payroll();
        assertFalse (payroll.equals(null));
    }

    @Test
    void findPayrollByEmployeeId() {
        String uri = "/payroll/get/3";
        Payroll payroll = new Payroll();
        assertEquals (0,payroll.getEmployeeId());
    }

    @Test
    void addPayroll() throws Exception{
        String uri = "/payroll/add/";
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(3);
        payroll.setDeduction(8000);
        payroll.setAllowance(7000);
        payroll.setBasic(6500);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        assertEquals (3,payroll.getEmployeeId());
    }

    @Test
    void deletePayroll() {
        String uri = "/payroll/2";
        Payroll payroll = new Payroll();
        assertEquals(0,payroll.getEmployeeId());
    }

    @Test
    void updatePayroll() throws Exception{
        String uri = "/payroll/1";
        Payroll payroll = new Payroll();
        int expected = 5000;
        payroll.setBasic(5000);
        payroll.setAllowance(4000);
        payroll.setDeduction(3000);
        payroll.setEmployeeId(3);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        assertEquals (expected,payroll.getBasic());
    }
}