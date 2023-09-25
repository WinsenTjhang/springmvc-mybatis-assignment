package com.winsen.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.winsen.demo.repository")
@SpringBootApplication
public class MyBatisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisProjectApplication.class, args);
	}

}