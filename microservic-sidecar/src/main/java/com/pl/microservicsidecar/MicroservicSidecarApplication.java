package com.pl.microservicsidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class MicroservicSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicSidecarApplication.class, args);
	}
}
