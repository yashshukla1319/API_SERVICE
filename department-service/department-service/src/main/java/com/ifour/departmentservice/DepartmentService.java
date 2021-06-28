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


    public void updateDepartment(Integer dept_id, String dept_name) {
        Department department = departmentRepository.findById(dept_id).orElseThrow(()->new IllegalStateException("Department with Id"+dept_id+"is not present"));

        if(!Objects.equals(department.getDept_id(),dept_id))
        {
            department.setDept_id(dept_id);
        }

        if(!Objects.equals(department.getDept_name(),dept_name))
        {
            department.setDept_name(dept_name);
        }

        departmentRepository.save(department);
    }

    public void addDepartment(Department department) {
        Optional<Department> getDepartmentBydept_id =  departmentRepository.findById(department.getDept_id());
        if (getDepartmentBydept_id !=null && getDepartmentBydept_id.isPresent()){
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

    public List<Department> getDepartmentBydept_id(Integer dept_id) {
        return departmentRepository.findAll();
    }

    public List<Employee> findEmployeeById(Integer dept_id) {

        RestTemplate restTemplate = new RestTemplate();
        List<Employee> employeeInDept = Arrays.asList(new Employee(1, "yash", 10000, 101),
                new Employee(2, "gaurav", 15000, 101));

        return employeeInDept.stream().map(department -> {
            new Department(101, "java");

            Employee employee = restTemplate.getForObject("http://localhost:8079/employee/get" + departmentRepository.findAll(),getDepartmentBydept_id(101), Employee.class);
            return new Department(employee.getId(), employee.getName(), employee.getSalary());
        })
                .collect(Collectors.toList());
        //return departmentRepository.findEmployeeById(dept_id);
        /*if (findEmployeeById(id) != null && findEmployeeById(id).isEmpty()){
            throw new IllegalStateException("Employee with this Id is not present");
        }
        return (List<Employee>) departmentRepository.findEmployeeById(id);*/
    }

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

