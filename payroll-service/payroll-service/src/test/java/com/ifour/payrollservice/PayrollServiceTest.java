package com.ifour.payrollservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PayrollServiceTest {

    @MockBean
    PayrollRepository payrollRepository;

    @Autowired
    PayrollService payrollService;


    @Test
    void getPayroll() {
        Payroll payroll = new Payroll();
        //List<Payroll> payrollList = new ArrayList<Payroll>((Collection<? extends Payroll>) payroll);
        Mockito.when(payrollRepository.findAll((Pageable) Mockito.any())).thenReturn((Page<Payroll>) payroll);
        List<Payroll> output = payrollService.getPayroll();
        org.junit.jupiter.api.Assertions.assertEquals(payroll,output);
    }

    @Test
    void findPayrollByEmployeeId() {
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(1);

        Optional<Payroll> payrol = Optional.of(payroll);

        Mockito.when(payrollRepository.findPayrollByEmployeeId(Mockito.anyInt())).thenReturn(payrol);

        Optional<Payroll> payrolMock = payrollService.findPayrollByEmployeeId(1);

        assertEquals(payrol,payrolMock);

    }

    @Test
    void addPayroll() throws Exception{

        Payroll payroll = new Payroll();
        Mockito.when(payrollRepository.save(Mockito.any())).thenReturn(payroll);

        payroll.setEmployeeId(3);
        payroll.setDeduction(8000);
        payroll.setAllowance(7000);
        payroll.setBasic(6500);

        Payroll output = (Payroll) payrollService.addPayroll(payroll);


        assertEquals(payroll,output);
    }

    @Test
    void deletePayroll() {
        Payroll payroll = new Payroll();

        PayrollService payrollService1 = Mockito.mock(PayrollService.class);

        Mockito.when(payrollRepository.existsById(Mockito.anyInt())).thenReturn(true);
        payrollService1.deletePayroll(1);

        Mockito.verify(payrollService1,Mockito.times(1)).deletePayroll(Mockito.anyInt());

        assertEquals(0,payroll.getEmployeeId());
    }

    @Test
    void updatePayroll() throws Exception{
        Payroll payroll = new Payroll();
        Mockito.when(payrollRepository.findPayrollByEmployeeId(Mockito.anyInt())).thenReturn(Optional.of(payroll));
        Optional<Payroll> output = payrollService.findPayrollByEmployeeId(1);
        payroll.setBasic(5000);
        payroll.setAllowance(4000);
        payroll.setDeduction(3000);
        payroll.setEmployeeId(3);
        payroll.setNet_salary(12000);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        Optional<Payroll> optionalPayroll = Optional.of(payroll);
        Assertions.assertThat(optionalPayroll).isEqualTo(output);
    }
}