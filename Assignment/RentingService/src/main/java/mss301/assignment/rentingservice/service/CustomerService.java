package mss301.assignment.rentingservice.service;

import mss301.assignment.rentingservice.dtos.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "${customer.service.url}")
public interface CustomerService {
    @GetMapping("/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable int id);
}
