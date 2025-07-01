package mss301.assignment.customerservice.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;


@Entity
@Table(name = "Customer")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private int customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Email")
    private String email;

    @Column(name = "CustomerBirthDate")
    private Date customerBirthDate;

    @Column(name = "CustomerStatus")
    private boolean customerStatus;


    @Column(name = "Password")
    private String password;
}
