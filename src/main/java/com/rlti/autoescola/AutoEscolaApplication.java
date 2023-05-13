package com.rlti.autoescola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Auto Escola API", version = "1.0.0", description = "Gestão de Auto Escola"))
public class AutoEscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoEscolaApplication.class, args);
	}

}
