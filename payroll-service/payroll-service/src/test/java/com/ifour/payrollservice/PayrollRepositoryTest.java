package com.ifour.payrollservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PayrollRepositoryTest {
    @MockBean
    PayrollRepository payrollRepository;
    @Autowired
            PayrollService payrollService;
    Payroll payroll = new Payroll();

    @Test
    void findPayrollByEmployeeId() {

        try {
            Optional<Payroll> payrollOptional = Optional.of(payroll);
            Mockito.when(payrollRepository.findPayrollByEmployeeId(Mockito.anyInt())).thenReturn(payrollOptional);
            Optional<Payroll> result = payrollService.findPayrollByEmployeeId(1);
            assertEquals(payrollOptional,result);
        }
        catch (NullPointerException e){
            throw e;
        }
    }
}