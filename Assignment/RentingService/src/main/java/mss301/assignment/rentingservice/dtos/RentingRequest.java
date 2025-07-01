package mss301.assignment.rentingservice.dtos;

import lombok.Data;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;

@Data
public class RentingRequest {
    private double totalPrice;
    private int customerId;
    private boolean rentingStatus;
    private int carId;
    private Date startDate;
    private Date endDate;
}
