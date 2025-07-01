package mss301.assignment.rentingservice.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "RentingDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "RentingTransactionId")
    private RentingTransaction rentingTransaction;

    @Column(name = "CarId")
    private int carId;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "Price")
    private double price;

}
