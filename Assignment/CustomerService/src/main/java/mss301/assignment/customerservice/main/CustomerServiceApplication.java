package mss301.assignment.customerservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan({"mss301.assignment.customerservice.controller", "mss301.assignment.customerservice.service"})
@EnableJpaRepositories(basePackages = "mss301.assignment.customerservice.repository")
@EntityScan(basePackages = "mss301.assignment.customerservice.pojos")

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
