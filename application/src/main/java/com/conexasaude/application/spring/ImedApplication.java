package com.conexasaude.application.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.conexasaude"})
@EnableJpaRepositories(basePackages = {"com.conexasaude.repository"})
@EntityScan(basePackages = {"com.conexasaude.entity"})
@SpringBootApplication
public class ImedApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImedApplication.class, args);
  }
}
