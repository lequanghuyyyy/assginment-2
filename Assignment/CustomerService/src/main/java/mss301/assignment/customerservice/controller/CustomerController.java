package mss301.assignment.customerservice.controller;


import mss301.assignment.customerservice.dto.CustomerDTO;
import mss301.assignment.customerservice.pojos.Customers;
import mss301.assignment.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Customer not found with id: " + id);
        }
    }


    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customer) {
        try {
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error inserting customer: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable int id, @RequestBody CustomerDTO customers) {
        try {
            return ResponseEntity.ok(customerService.updateAccount(id, customers));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Customer not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Customer not found with id: " + id);
        }
    }


}
