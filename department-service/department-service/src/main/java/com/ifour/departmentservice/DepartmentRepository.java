package com.ifour.departmentservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Employee> findEmployeeByDeptId(Integer deptId);
    List<Department> findAllByDeptId(Integer deptId);
    List<Payroll> findPayrollByEmployeeId(Integer employeeId);
}
