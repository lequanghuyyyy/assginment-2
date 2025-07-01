package mss301.assignment.carservice.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Manufacturer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manufacturerId;

    @Column(name = "ManufacturerName")
    private String manufacturerName;

    @Column(name = "Description")
    private String Description;

    @Column(name = "ManufacturerCountry")
    private String ManufacturerCountry;
    
    @OneToMany(mappedBy = "manufacturer")
    private List<CarInformation> carInformationList;


}
