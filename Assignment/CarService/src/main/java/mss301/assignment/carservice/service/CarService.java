package mss301.assignment.carservice.service;

import mss301.assignment.carservice.dto.CarDTO;
import mss301.assignment.carservice.pojos.CarInformation;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();

    CarDTO getCarById(int id);

    CarDTO addCar(CarDTO car);

    CarDTO updateCar(CarDTO car);

}
