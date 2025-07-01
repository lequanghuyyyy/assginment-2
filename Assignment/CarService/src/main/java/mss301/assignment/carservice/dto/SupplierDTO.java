package mss301.assignment.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private int supplierId;

    private String supplierName;

    private String supplierDescription;

    private String supplierAddress;
}
