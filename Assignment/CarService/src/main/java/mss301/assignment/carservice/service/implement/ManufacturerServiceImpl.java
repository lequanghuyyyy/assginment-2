package mss301.assignment.carservice.service.implement;

import mss301.assignment.carservice.dto.ManufacturerDTO;
import mss301.assignment.carservice.repository.ManufacturerRepository;
import mss301.assignment.carservice.service.ManufacturerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<ManufacturerDTO> getAllManufacturers() {
        return manufacturerRepository.findAll().stream().map(manufacturer -> {
            ManufacturerDTO dto = new ManufacturerDTO();
            BeanUtils.copyProperties(manufacturer, dto);
            return dto;
        }).toList();
    }
}
