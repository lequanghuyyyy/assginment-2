package mss301.assignment.carservice.service.implement;

import mss301.assignment.carservice.dto.CarDTO;
import mss301.assignment.carservice.pojos.CarInformation;
import mss301.assignment.carservice.repository.CarInformationRepository;
import mss301.assignment.carservice.repository.ManufacturerRepository;
import mss301.assignment.carservice.repository.SupplierRepository;
import mss301.assignment.carservice.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarInformationRepository carInformationRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;


    @Override
    public List<CarDTO> getAllCars() {
        List<CarInformation> cars = carInformationRepository.findAll();
        CarDTO carDTO = new CarDTO();

        return cars.stream().map(car -> {
            BeanUtils.copyProperties(car, carDTO);
            carDTO.setSupplier(car.getSupplier().getSupplierName());
            carDTO.setManufacturer(car.getManufacturer().getManufacturerName());
            return carDTO;
        }).toList();
    }

    @Override
    public CarDTO getCarById(int id) {
        CarInformation car = carInformationRepository.findById(id).get();
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(car, carDTO);
        carDTO.setSupplier(car.getSupplier().getSupplierName());
        carDTO.setManufacturer(car.getManufacturer().getManufacturerName());
        return carDTO;
    }

    @Override
    public CarDTO addCar(CarDTO car) {
        CarInformation carInformation = new CarInformation();
        return getCarDTO(car, carInformation);
    }


    @Override
    public CarDTO updateCar(CarDTO car) {
        CarInformation existingCar = carInformationRepository.findById(car.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        return getCarDTO(car, existingCar);
    }

    private CarDTO getCarDTO(CarDTO car, CarInformation existingCar) {
        BeanUtils.copyProperties(car, existingCar);
        existingCar.setSupplier(supplierRepository.findById(car.getSupplierId()).get());
        existingCar.setManufacturer(manufacturerRepository.findById(car.getManufacturerId()).get());
        CarInformation updatedCar = carInformationRepository.save(existingCar);
        CarDTO updatedCarDTO = new CarDTO();
        BeanUtils.copyProperties(updatedCar, updatedCarDTO);
        updatedCarDTO.setSupplier(updatedCar.getSupplier().getSupplierName());
        updatedCarDTO.setManufacturer(updatedCar.getManufacturer().getManufacturerName());
        return updatedCarDTO;
    }
}
