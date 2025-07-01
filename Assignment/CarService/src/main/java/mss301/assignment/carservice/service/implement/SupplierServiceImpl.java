package mss301.assignment.carservice.service.implement;

import mss301.assignment.carservice.dto.SupplierDTO;
import mss301.assignment.carservice.repository.SupplierRepository;
import mss301.assignment.carservice.service.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplier -> {
            SupplierDTO supplierDTO = new SupplierDTO();
            BeanUtils.copyProperties(supplier, supplierDTO);
            return supplierDTO;
        }).toList();
    }
}
