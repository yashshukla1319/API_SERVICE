package com.ifour.employeeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;
    @MockBean
            EmployeeRepository employeeRepository;
    Employee employee = new Employee();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getEmployee() {
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee));
        List<Employee> output = employeeService.getEmployee();
        assertEquals(employee,output);
    }

    @Test
    void getEmployeeById() {
        Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));
        Optional<Employee> output = employeeService.getEmployeeById(1);
        assertEquals(employee,output);
    }

    @Test
    void addNewEmployee() throws Exception{
        employee.setName("amit");
        employee.setDeptId(201);
        employee.setId(1);
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        Optional<Employee> output = employeeService.getEmployeeById(1);
        String inputJson = objectMapper.writeValueAsString(employee);
        assertEquals (inputJson,output);
    }

    @Test
    void deleteEmployee() {
        Mockito.when(employeeRepository.existsById(Mockito.anyInt())).thenReturn(true);
        Mockito.verify(employeeRepository,null);
        assertNull(employee);
    }

    @Test
    void updateEmployee() throws Exception{
        employee.setName("karan");
        employee.setDeptId(201);
        employee.setId(2);
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);
        Optional<Employee> output = employeeService.getEmployeeById(2);
        String inputJson = objectMapper.writeValueAsString(employee);
        assertEquals (inputJson,output);
    }

    @Test
    void findAllByDeptId() throws Exception{
        Mockito.when(employeeRepository.findAllByDeptId(Mockito.anyInt())).thenReturn(List.of(employee));
        List<Employee> output = employeeService.findAllByDeptId(101);
        Employee input = objectMapper.convertValue(output,Employee.class);
        assertEquals(employee,input);
    }
}