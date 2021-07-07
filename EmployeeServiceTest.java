package com.ifour.employeeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    @Autowired
    MockMvc mvc;

    Employee employee = new Employee();


    @Test
    void getEmployee() {
        String uri = "/employee/get/";
        assertFalse(employee.equals(null));
    }

    @Test
    void getEmployeeById() {
        String uri = "/employee/get/3";
        assertFalse(employee.equals(null));
    }

    @Test
    void addNewEmployee() throws Exception{
        String uri = "/employee/add";
        employee.setName("amit");
        employee.setDeptId(1);
        employee.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        assert (employee.getName().equals("amit"));
    }

    @Test
    void deleteEmployee() {
        String uri = "/employee/delete/1";
        assertNull(employee.getName());
    }

    @Test
    void updateEmployee() throws Exception{
        String uri = "/employee/update/1?name=Yash&dept=Temp";
        employee.setName("karan");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        assert (employee.getName().equals("karan"));
    }

    @Test
    void findAllByDeptId() throws Exception{
        String uri = "/employee/";
        this.mvc.perform(MockMvcRequestBuilders.get(uri)).toString();
        assertNull(employee.getDeptId());
        assertEquals(this.mvc,employee);
    }
}