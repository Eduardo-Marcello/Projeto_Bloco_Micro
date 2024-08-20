package br.com.marcello.escalaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EscalaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EscalaServiceApplication.class, args);
    }

}
