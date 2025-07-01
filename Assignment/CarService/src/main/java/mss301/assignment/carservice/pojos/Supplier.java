package mss301.assignment.carservice.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(name = "SupplierName")
    private String supplierName;

    @Column(name = "SupplierDescription")
    private String supplierDescription;

    @Column(name = "SupplierAddress")
    private String supplierAddress;

    @OneToMany(mappedBy = "supplier")
    private List<CarInformation> carInformationList;
}
