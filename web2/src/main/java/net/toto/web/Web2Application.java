package net.toto.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages="net.toto.mapper")
@ComponentScan("net.toto")
public class Web2Application {

	public static void main(String[] args) {
		SpringApplication.run(Web2Application.class, args);
	}

}
