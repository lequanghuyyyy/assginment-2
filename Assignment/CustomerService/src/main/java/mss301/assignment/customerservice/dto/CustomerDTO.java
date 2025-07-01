package mss301.assignment.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private int customerId;

    private String customerName;

    private String telephone;

    private String email;

    private Date customerBirthDate;

    private int customerStatus;

    private String password;
}
