package com.GoCook.Boundaries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.GoCook.Controllers","com.GoCook.Boundaries"})
@EntityScan("com.GoCook.Entities")
public class GoCookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoCookApplication.class, args);
	}

}
