package mss301.assignment.rentingservice.service;

import mss301.assignment.rentingservice.dtos.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service", url = "${car.service.url}")
public interface CarService {
    @GetMapping("/car/{id}")
    CarDTO getCarById(@PathVariable int id);
}
