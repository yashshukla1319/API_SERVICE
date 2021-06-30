package com.ifour.departmentservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findEmployeeByDeptId(Integer deptId);

    Department findPayrollByEmployeeId(Integer employeeId);
}
