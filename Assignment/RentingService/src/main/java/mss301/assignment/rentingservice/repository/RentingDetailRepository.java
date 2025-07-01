package mss301.assignment.rentingservice.repository;

import mss301.assignment.rentingservice.pojos.RentingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentingDetailRepository extends JpaRepository<RentingDetail, Integer> {

    Optional<RentingDetail> findByRentingTransaction_RentingTransactionId(int rentingTransactionId);

}
