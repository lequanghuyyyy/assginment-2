package mss301.assignment.rentingservice.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mss301.assignment.rentingservice.pojos.RentingTransaction;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentingResponse {
    private int rentingTransactionId;

    private Date rentingDate;

    private double totalPrice;

    private int customerId;

    private boolean rentingStatus;

    private int carId;

    private Date startDate;

    private Date endDate;

    private double price;
}
