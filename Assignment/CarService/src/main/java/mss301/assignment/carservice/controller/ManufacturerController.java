package mss301.assignment.carservice.controller;


import mss301.assignment.carservice.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
@CrossOrigin(origins = "*")
public class ManufacturerController {

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<?> getManufacturers() {
        return ResponseEntity.ok().body(manufacturerService.getAllManufacturers());
    }
}
