package com.ifour.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController implements Serializable {
    Department department = new Department();
    @Autowired
    public DepartmentService departmentService;
    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping(path = "/get")
    public List<Department> getDepartment() {
        return departmentService.getDepartment();
    }

    @RequestMapping(path = "/get/{id}")
    public List<Department> getDepartmentBydept_id(@PathVariable("id") Integer dept_id) {
        return departmentService.getDepartmentBydept_id(dept_id);
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);

    }

    @RequestMapping(path = "/delete/{delete}", method = RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable("delete") Integer dept_id) {
        departmentService.deleteDepartment(dept_id);
    }


    @RequestMapping(path = "/update/{put}", method = RequestMethod.PUT)
    public void updateDepartment(@PathVariable("put")
                                 @RequestParam(required = false) Integer dept_id,
                                 @RequestParam(required = false) String dept_name) {
        departmentService.updateDepartment(dept_id, dept_name);
    }

    @RequestMapping(path = "/getemployee/{id}", method = RequestMethod.GET)
    public List<Department> findEmployeeById(@PathVariable("id") Integer id)
    {
        List<Employee> employeeInDept = Arrays.asList(new Employee(1, "yash", 10000, 101),
                new Employee(2, "gaurav", 15000, 101));

        return employeeInDept.stream().map(department -> {
            new Department(101, "java");

            Employee employee = restTemplate.getForObject("http://localhost:8079/employee/getbydept" + departmentService.getDepartmentBydept_id(101), Employee.class);
            return new Department(employee.getId(), employee.getName(), employee.getSalary());
        })
                .collect(Collectors.toList());
    }


    /*@RequestMapping(path ="/removeemployee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id")Integer id)
    {
        departmentService.deleteEmployeeById(id);
    }*/

}

