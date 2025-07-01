package mss301.assignment.carservice.controller;

import mss301.assignment.carservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> getAllSuppliers() {
        return ResponseEntity.ok().body(supplierService.getAllSuppliers());
    }
}
