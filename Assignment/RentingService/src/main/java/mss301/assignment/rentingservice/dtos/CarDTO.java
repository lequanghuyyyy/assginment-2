package mss301.assignment.rentingservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private int carId;

    private String carName;

    private String carDescription;

    private int numberOfDoors;

    private int seatingCapacity;

    private String fuelType;

    private int year;

    private String carStatus;

    private double carRentingPricePerDay;

    private String supplier;

    private int supplierId;

    private String manufacturer;

    private int manufacturerId;
}
