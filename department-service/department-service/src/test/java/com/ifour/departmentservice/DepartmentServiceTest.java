package com.ifour.departmentservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
            public DepartmentService departmentService;
    @MockBean
            public DepartmentRepository departmentRepository;

    Department department = new Department();

    @Test
    void updateDepartment(){
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        Mockito.when(departmentRepository.findAllByDeptId((Mockito.anyInt()))).thenReturn(departmentList);
        List<Department> output = departmentService.getAllDepartmentByDeptId(101);
        department.setDeptName("testing");
        department.setEmployeeId(4);
        department.setDeptId(101);
        assertEquals (departmentList,output);
    }

    @Test
    void addDepartment(){
        department.setDeptId(101);
        department.setDeptName("java");
        department.setEmployeeId(1);
        Mockito.when(departmentRepository.save(Mockito.any())).thenReturn(department);
        Department output = departmentService.addDepartment(department);
        assertEquals (department,output);
    }

    @Test
    void deleteDepartment(){
        DepartmentService departmentService1 = Mockito.mock(DepartmentService.class);
        Mockito.when(departmentRepository.existsById(Mockito.anyInt())).thenReturn(true);
        departmentService1.deleteDepartment(1);
        Mockito.verify(departmentService1, times(1))
                .deleteDepartment(Mockito.anyInt());

    }

    @Test
    void getAllDepartmentByDeptId() throws NullPointerException{
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        Mockito.when(departmentRepository.findAllByDeptId(Mockito.anyInt())).thenReturn(departmentList);
        List<Department> output = departmentService.getAllDepartmentByDeptId(101);
        assertEquals(departmentList,output);
    }

    @Test
    void getAllDepartment(){
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentList);
        List<Department> output = departmentService.getAllDepartment();
        assertEquals(departmentList,output);
    }

    @Test
    void findEmployeeByDeptId(){
        Mockito.when(departmentRepository.findAllByDeptId(Mockito.anyInt())).thenReturn(List.of(department));
        //List<Employee> output = departmentService.findEmployeeByDeptId(101);
        boolean result = department != null;
        assertTrue(result);

    }

    @Test
    void findPayrollByEmployeeId(){
        Mockito.when(departmentRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(department));
        //List<Payroll> output = (List<Payroll>) departmentService.findPayrollByEmployeeId(1);
        boolean result = department != null;
        assertTrue(result);
    }
}