package com.ifour.departmentservice;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Configurable
public class DepartmentConfig {
    @Bean
    CommandLineRunner commandLineRunner (DepartmentRepository repository)
    {
        return args -> {
            Department devloper = new Department(101,"java");
            Department frontend = new Department(102,"angular");
            Department backend = new Department(103,".net");
            //Department devloper = new Department(4,101,"java","dhaval");
            //Department frontend = new Department(5,102,"angular","dhairya");
            //Department backend = new Department(6,103,".net","karan");
            repository.saveAll(List.of(devloper,frontend,backend));
        };
    }

}


