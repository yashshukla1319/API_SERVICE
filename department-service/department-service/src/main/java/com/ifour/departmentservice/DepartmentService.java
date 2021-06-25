package com.ifour.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
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

    public List<Employee> findEmployeeById() {
        return findEmployeeById();
        /*if (findEmployeeById(id) != null && findEmployeeById(id).isEmpty()){
            throw new IllegalStateException("Employee with this Id is not present");
        }
        return (List<Employee>) departmentRepository.findEmployeeById(id);*/
    }

    public void deleteEmployeeById(Integer id) {
        boolean exist = departmentRepository.existsById(id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists in Department");
        }
        departmentRepository.deleteEmployeeById(id);
    }

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }
}

}
