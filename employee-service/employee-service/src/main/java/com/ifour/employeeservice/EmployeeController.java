package com.ifour.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping(path = "/get")
    public List<Employee> getEmployee(@RequestParam("no") int no,@RequestParam("size") int size)
    {
        //Pageable pageable = PageRequest.of(1,5);
        return employeeService.getEmployee(no,size);
    }

    @RequestMapping(path = "/get/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id")Integer id)
    {
        System.out.println(id);
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(path = "/getId")
    public List<Employee> getEmployeeIn(@RequestParam String id)
    {
        List<String> ids = Arrays.asList((id.split(",")));
        List<Integer> intIds =  ids.stream().mapToInt(Integer::parseInt).boxed().toList();

        //Integer integer = Integer.parseInt(String.valueOf(ids));
        return employeeService.getEmployeeIn(intIds);
    }

    @RequestMapping(path = "/getName")
    public List<Employee> getEmployeeByName(@RequestParam("name")String name)
    {
        return employeeService.getEmployeeByName(name);
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


