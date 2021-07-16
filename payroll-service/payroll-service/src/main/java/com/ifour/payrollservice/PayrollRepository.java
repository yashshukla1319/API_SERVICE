package com.ifour.payrollservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
      Optional<Payroll> findPayrollByEmployeeId(Integer employeeId);
}
