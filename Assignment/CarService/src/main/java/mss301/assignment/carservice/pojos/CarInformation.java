package mss301.assignment.carservice.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

@Entity
@Table(name = "CarInformation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "CarName")
    private String carName;

    @Column(name = "CarDescription")
    private String carDescription;

    @Column(name = "NumberOfDoors")
    private int numberOfDoors;

    @Column(name = "SeatingCapacity")
    private int seatingCapacity;

    @Column(name = "FuelType")
    private String fuelType;

    @Column(name = "Year")
    private int year;

    @Column(name = "CarStatus")
    private boolean carStatus;

    @Column(name = "CarRentingPricePerDay")
    private double carRentingPricePerDay;

    @ManyToOne
    @JoinColumn(name = "SupplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "ManufacturerId")
    private Manufacturer manufacturer;
}
