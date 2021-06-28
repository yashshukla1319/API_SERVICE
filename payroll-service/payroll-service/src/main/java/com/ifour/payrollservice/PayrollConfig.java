package com.ifour.payrollservice;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;

@Configurable
public class PayrollConfig {
    @Bean
    CommandLineRunner commandLineRunner(PayrollRepository repository)
    {
        return args -> {
            Payroll one = new Payroll(1,15000,8000,5000,14000);
            repository.saveAll(List.of(one));
        };
    }
}
