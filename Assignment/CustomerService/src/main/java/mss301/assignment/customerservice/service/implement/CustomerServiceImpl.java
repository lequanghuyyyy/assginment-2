package mss301.assignment.customerservice.service.implement;

import mss301.assignment.customerservice.dto.CustomerDTO;
import mss301.assignment.customerservice.pojos.Customers;
import mss301.assignment.customerservice.repository.CustomerRepository;
import mss301.assignment.customerservice.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customers> customer = customerRepository.findAll();

        return customer.stream().map(c -> {
            CustomerDTO dto = new CustomerDTO();
            BeanUtils.copyProperties(c, dto);
            return dto;
        }).toList();
    }

    @Override
    public CustomerDTO getCustomerById(int id) throws RuntimeException {
        Customers customer = customerRepository.findById(id).orElse(null);
        CustomerDTO dto = new CustomerDTO();
        if (customer != null) {
            BeanUtils.copyProperties(customer, dto);
        }
        return dto;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customers customer = new Customers();
        BeanUtils.copyProperties(dto, customer);
        customerRepository.save(customer);
        return dto;
    }

    @Override
    public CustomerDTO updateAccount(int id, CustomerDTO customers) {
        Customers existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        if (existingCustomer != null) {
            BeanUtils.copyProperties(customers, existingCustomer, "customerId");
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }

        customerRepository.save(existingCustomer);
        CustomerDTO updatedCustomer = new CustomerDTO();
        BeanUtils.copyProperties(existingCustomer, updatedCustomer);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(int id) throws RuntimeException {
        Customers existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
        }
    }
}
