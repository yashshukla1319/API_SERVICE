package com.ifour.payrollservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest
class PayrollControllTest {
    @MockBean
    PayrollService payrollService;
    @Autowired
    MockMvc mvc;
    @Test
    void getPayroll() throws Exception{
        String uri = "/payroll/get";
        this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findPayrollByEmployeeId() throws Exception{
        String uri = "/payroll/get/1";
        this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void addPayroll() throws Exception{
        String uri = "/payroll/add";
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(1);
        payroll.setDeduction(8000);
        payroll.setAllowance(7000);
        payroll.setBasic(6500);
        payroll.setNet_salary(7500);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deletePayroll() throws Exception{
        String uri = "/payroll/delete/2";
        this.mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updatePayroll() throws Exception{
        String uri = "/payroll/update/1";
        Payroll payroll = new Payroll();
        payroll.setBasic(5000);
        payroll.setAllowance(4000);
        payroll.setDeduction(3000);
        payroll.setEmployeeId(3);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        this.mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}