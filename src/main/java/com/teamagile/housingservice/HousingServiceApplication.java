package com.teamagile.housingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class HousingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingServiceApplication.class, args);
    }

}
