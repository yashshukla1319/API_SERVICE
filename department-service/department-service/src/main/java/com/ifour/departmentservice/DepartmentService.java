package com.ifour.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableJpaRepositories
public class DepartmentService {
    @Autowired
    public DepartmentRepository departmentRepository;


    public void updateDepartment(Integer deptId, String deptName) {
        Department department = departmentRepository.findById(deptId).orElseThrow(()->new IllegalStateException("Department with Id"+deptId+"is not present"));

        if(!Objects.equals(department.getDeptId(),deptId))
        {
            department.setDeptId(deptId);
        }

        if(!Objects.equals(department.getDeptName(),deptName))
        {
            department.setDeptName(deptName);
        }

        departmentRepository.save(department);
    }

    public void addDepartment(Department department) {
        Optional<Department> getDepartmentBydeptId =  departmentRepository.findById(department.getDeptId());
        if (getDepartmentBydeptId !=null && getDepartmentBydeptId.isPresent()){
            throw new IllegalStateException("Department with this ID already exists");
        }

        departmentRepository.save(department);

    }

    public void deleteDepartment(Integer dept_id) {
        boolean exist = departmentRepository.existsById(dept_id);
        if(!exist)
        {
            throw new IllegalStateException("Department with Id: "+dept_id+"does not exists");
        }
        departmentRepository.deleteById(dept_id);
    }

    public List<Department> getDepartmentBydeptId(Integer deptId) {
        return departmentRepository.findAll();
    }

    //public List<Employee> findEmployeeById(Integer id) {
      //  RestTemplate restTemplate = new RestTemplate();
        //    return ((List) restTemplate.getForObject("http://localhost:8079/employee/get", Employee.class));
    //}
        //return departmentRepository.findEmployeeById(dept_id);
        /*if (findEmployeeById(id) != null && findEmployeeById(id).isEmpty()){
            throw new IllegalStateException("Employee with this Id is not present");
        }
        return (List<Employee>) departmentRepository.findEmployeeById(id);*/


    /*public void deleteEmployeeById(Integer id) {
        boolean exist = departmentRepository.existsById(id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists in Department");
        }
        departmentRepository.deleteEmployeeById(id);
    }*/

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }
}

