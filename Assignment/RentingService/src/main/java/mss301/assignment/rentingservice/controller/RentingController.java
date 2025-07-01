package mss301.assignment.rentingservice.controller;


import mss301.assignment.rentingservice.dtos.RentingRequest;
import mss301.assignment.rentingservice.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/renting")
@CrossOrigin(origins = "*")
public class RentingController {

    @Autowired
    RentingService rentingService;

    @GetMapping
    public ResponseEntity<?> getAllRenting() {
        return new ResponseEntity<>(rentingService.getAllRentingTransactions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRenting(@RequestBody RentingRequest request) {
        return new ResponseEntity<>(rentingService.createRentingTransaction(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateRenting(@RequestParam int rentingId, @RequestBody RentingRequest request) {
        return new ResponseEntity<>(rentingService.updateRentingTransaction(rentingId, request), HttpStatus.OK);
    }
}
