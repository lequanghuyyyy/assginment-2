package mss301.assignment.customerservice.service;

import mss301.assignment.customerservice.dto.CustomerDTO;
import mss301.assignment.customerservice.pojos.Customers;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(int id) throws RuntimeException;

    CustomerDTO createCustomer(CustomerDTO dto);

    CustomerDTO updateAccount(int id, CustomerDTO dto);

    void deleteCustomer(int id) throws RuntimeException;


}

