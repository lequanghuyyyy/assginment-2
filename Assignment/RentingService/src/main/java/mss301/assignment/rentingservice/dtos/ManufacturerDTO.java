package mss301.assignment.rentingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDTO {
    private int manufacturerId;

    private String manufacturerName;

    private String Description;

    private String ManufacturerCountry;

}
