package mss301.assignment.carservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mss301.assignment.carservice.controller", "mss301.assignment.carservice.service"})
@EnableJpaRepositories(basePackages = "mss301.assignment.carservice.repository")
@EntityScan(basePackages = "mss301.assignment.carservice.pojos")
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

}
