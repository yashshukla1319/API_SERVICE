package com.ifour.departmentservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {
    @MockBean
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentService departmentService;
    Department department = new Department();

    @Test
    void findAllByDeptId() {
        try {
            List<Department> departments = new ArrayList<>();
            departments.add(department);
            Mockito.when(departmentRepository.findAllByDeptId(Mockito.anyInt())).thenReturn(departments);
            List<Department> departmentList = departmentService.getAllDepartmentByDeptId(101);
            assertEquals(departments,departmentList);
        } catch (NullPointerException e) {
            throw e;
        }
    }
}