package com.example.JdbcTemplateBySpring;

import com.example.JdbcTemplateBySpring.model.EmployeeInfo;
import com.example.JdbcTemplateBySpring.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcTemplateBySpringApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(JdbcTemplateBySpringApplication.class, args);
		EmployeeInfo employeeInfo=context.getBean(EmployeeInfo.class);
		EmployeeService employeeService=context.getBean(EmployeeService.class);
		employeeInfo.setId(101);
		employeeInfo.setName("afrid");
		employeeInfo.setSalary(25000);
		employeeService.addEmployee(employeeInfo);
		List<EmployeeInfo> employeeInfoList=employeeService.getAll();
		System.out.println(employeeInfoList);



	}

}
