package com.ifour.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getEmployee()
    {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id)
    {
        return employeeRepository.findById(id);
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> getEmployeeById =  employeeRepository.findById(employee.getId());
        if(getEmployeeById != null && getEmployeeById.isPresent())
        {
            throw new IllegalStateException("Id already present.");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        boolean exist = employeeRepository.existsById(id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id"+id+"does not exists");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Integer id, String name, String deptId, Integer salary)
    {
        System.out.println(id);
        System.out.println(name);
        System.out.println(deptId);
        System.out.println(salary);
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new IllegalStateException("Employee with Id"+id+"is not present"));

        if(name !=null &&  !Objects.equals(employee.getName(),name))
        {
            employee.setName(name);
        }

        if(salary !=null && salary>0 && !Objects.equals(employee.getSalary(),salary))
        {
            employee.setSalary(Math.toIntExact(salary));
        }

        employeeRepository.save(employee);
    }

    public List<Employee> findAllByDeptId(Integer deptId) {
        return employeeRepository.findAllByDeptId(deptId);

    }
}


