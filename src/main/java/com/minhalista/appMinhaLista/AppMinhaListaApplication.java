package com.minhalista.appMinhaLista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppMinhaListaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppMinhaListaApplication.class, args);
	}
}
