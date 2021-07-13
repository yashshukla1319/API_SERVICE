package com.ifour.departmentservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class DepartmentControllerTest {
    @Autowired
    public MockMvc mvc;
    @MockBean
    public DepartmentService departmentService;

    Department department = new Department();
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void getAllDepartment() throws Exception {
        String uri = "/department/get";
        this.mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentByDeptId() throws Exception {
        String uri = "/department/get/101";
        this.mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addDepartment() throws Exception {
        String uri = "/department/add";
        department.setDeptId(201);
        department.setDeptName("python");
        department.setEmployeeId(2);
        String input = objectMapper.writeValueAsString(department);
        this.mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(input)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteDepartment() throws Exception{
        String uri = "/department/delete/101";
        this.mvc.perform(MockMvcRequestBuilders.delete(uri).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateDepartment() throws Exception{
        String uri = "/department/update/101";
        department.setDeptName("web design");
        department.setDeptId(401);
        department.setEmployeeId(4);
        String input = objectMapper.writeValueAsString(department);
        this.mvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON_VALUE).contentType(input)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findEmployeeByDeptId() throws Exception{
        String uri = "/department/getemployee/1";
        this.mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findPayrollByEmployeeId() throws Exception{
        String uri = "/department/getPayroll/1";
        this.mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}