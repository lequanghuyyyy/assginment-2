package mss301.assignment.rentingservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = "mss301.assignment.rentingservice.service")
@ComponentScan({"mss301.assignment.rentingservice.controller", "mss301.assignment.rentingservice.service", "mss301.assignment.rentingservice.dtos"})
@EnableJpaRepositories(basePackages = "mss301.assignment.rentingservice.repository")
@EntityScan(basePackages = "mss301.assignment.rentingservice.pojos")
public class RentingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentingServiceApplication.class, args);
    }

}
