package mss301.assignment.rentingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private boolean customerStatus;

    private String password;
}
