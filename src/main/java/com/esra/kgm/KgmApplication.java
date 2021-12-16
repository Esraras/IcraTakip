package com.esra.kgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.esra.kgm.entity.Employee;
import com.esra.kgm.entity.EmployeeRepository;
import com.vaadin.flow.spring.annotation.EnableVaadin;

@SpringBootApplication(scanBasePackages = { "com.esra" })
@EnableJpaRepositories(basePackageClasses = { EmployeeRepository.class })
@EntityScan(basePackageClasses = { Employee.class })
@EnableVaadin({ "com.esra.kgm.ui" })
public class KgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(KgmApplication.class, args);
	}

}
