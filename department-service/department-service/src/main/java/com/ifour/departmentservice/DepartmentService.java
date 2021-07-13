package com.ifour.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@Service
public class DepartmentService {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public RestTemplate restTemplate;


    public Department updateDepartment(Integer deptId, String deptName, Integer employeeId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(() -> new IllegalStateException("Department with Id" + deptId + "is not present"));

        if (!Objects.equals(department.getDeptId(), deptId)) {
            department.setDeptId(deptId);
        }

        if (!Objects.equals(department.getDeptName(), deptName)) {
            department.setDeptName(deptName);
        }
        if (!Objects.equals(department.getEmployeeId(), employeeId)) {
            department.setEmployeeId(employeeId);
        }


        return departmentRepository.save(department);
    }

    public Department addDepartment(Department department) {
        Optional<Department> getDepartmentByDeptId = departmentRepository.findById(department.getDeptId());
        if (getDepartmentByDeptId != null && getDepartmentByDeptId.isPresent()) {
            throw new IllegalStateException("Department with this ID already exists");
        }

        return departmentRepository.save(department);

    }

    public void deleteDepartment(Integer dept_id) {
        boolean exist = departmentRepository.existsById(dept_id);
        if (!exist) {
            throw new IllegalStateException("Department with Id: " + dept_id + "does not exists");
        }
        departmentRepository.deleteById(dept_id);
    }

    public List<Department> getAllDepartmentByDeptId(Integer deptId) {
        return departmentRepository.findAllByDeptId(deptId);
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

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    /*public List<Employee> findEmployeeByDeptId(Integer deptId)
    {
        Employee response = restTemplate.getForObject("http://localhost:8079/employee/getbydept/201",Employee.class);
        Employee employee = new Employee();
        //employee.setEmployeeList();
        response.setEmployeeList((List<Employee>) employee);
        List<Employee> employeeList = response.getEmployeeList();
        return employeeList;
    }*/


    public List<Employee> findEmployeeByDeptId(Integer deptId) {
        ResponseEntity<List<Employee>> responseTemplate = restTemplate.exchange("http://localhost:8079/employee/getbydept/" + deptId,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

        List<Employee> employees = responseTemplate.getBody();
        return employees;
    }

    public Payroll findPayrollByEmployeeId(Integer employeeId){
        ResponseEntity<Payroll> responseEntity = restTemplate.exchange("http://localhost:8078/payroll/get/" + employeeId, HttpMethod.GET,
                null, new ParameterizedTypeReference<Payroll>() {});
        Payroll payrolls = responseEntity.getBody();
        return payrolls;

    }

}











    /*public ResponseTemplate findEmployeeByDeptId(Integer deptId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Department department = departmentRepository.findEmployeeByDeptId(deptId);

        Employee employee= restTemplate.getForObject("http://localhost:8079/employee/getbydept/"+department.getDeptId(), Employee.class);
        responseTemplate.setDepartment(department);
        responseTemplate.setEmployee(employee);

        return responseTemplate;
    }*/

    /*public ResponseTemplate findPayrollByEmployeeId(Integer employeeId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Department department = departmentRepository.findPayrollByEmployeeId(employeeId);

        Payroll payroll = restTemplate.getForObject("http://localhost:8078/payroll/getPayroll/" + department.getEmployeeId(), Payroll.class);
        responseTemplate.setPayroll(payroll);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }*/



