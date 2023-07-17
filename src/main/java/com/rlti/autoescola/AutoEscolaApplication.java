package com.rlti.autoescola;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title = "Auto Escola API", version = "1.0.0", description = "Gestão de Auto Escola"),
		servers = {@Server(url = "/auto-escola/api", description = "Default Server URL")})
public class AutoEscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoEscolaApplication.class, args);
	}

}
