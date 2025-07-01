package mss301.assignment.carservice.controller;


import mss301.assignment.carservice.dto.CarDTO;
import mss301.assignment.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "*")
public class CarServiceController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<?> getAllCart() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCarById(@PathVariable int id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody CarDTO dto) {
        return ResponseEntity.ok(carService.addCar(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody CarDTO dto) {
        return ResponseEntity.ok(carService.updateCar(dto));
    }
}
