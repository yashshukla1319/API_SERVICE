package com.ifour.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping(path = "/get")
    public List<Employee> getEmployee()
    {
        return employeeService.getEmployee();
    }

    @RequestMapping(path = "/get/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id")Integer id)
    {
        System.out.println(id);
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public void addNewEmployee(@RequestBody Employee employee)
    {
        employeeService.addNewEmployee(employee);
    }

    @RequestMapping(path = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("employeeId")Integer id)
    {
        employeeService.deleteEmployee(id);
    }


    @RequestMapping(path = "/update/{employeeId}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable("employeeId") Integer employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String deptId,
                               @RequestParam(required = false) Integer salary)
    {
        employeeService.updateEmployee(employeeId,name,deptId,salary);
    }
    @RequestMapping(path = "/getbydept/{deptId}",method = RequestMethod.GET)
    public List<Employee> findAllByDeptId(@PathVariable("deptId")Integer deptId) {
        return employeeService.findAllByDeptId(deptId);//.stream().toList();

    }
}


