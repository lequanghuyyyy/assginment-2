package mss301.assignment.rentingservice.pojos;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;

@Entity
@Table(name = "RentingTransaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RentingTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentingTransactionId;

    @Column(name = "RentingDate")
    private Date rentingDate;

    @Column(name = "TotalPrice")
    private double totalPrice;

    @Column(name = "CustomerId")
    private int customerId;

    @Column(name = "rentingStatus")
    private boolean rentingStatus;


}
