package mss301.assignment.carservice.repository;

import mss301.assignment.carservice.pojos.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Integer> {
}
