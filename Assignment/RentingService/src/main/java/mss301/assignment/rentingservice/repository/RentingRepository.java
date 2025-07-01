package mss301.assignment.rentingservice.repository;

import mss301.assignment.rentingservice.pojos.RentingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentingRepository extends JpaRepository<RentingTransaction, Integer> {
}
