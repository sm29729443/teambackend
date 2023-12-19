package com.twoTeam.groupProject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GroupProjectApplication {
	// one branch 測試

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
	}

}
