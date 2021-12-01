package com.example.project_YT;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.example.config")
public class ProjectYtApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectYtApplication.class, args);
		
	}

}
