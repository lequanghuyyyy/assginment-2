package mss301.assignment.customerservice.repository;

import mss301.assignment.customerservice.pojos.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
