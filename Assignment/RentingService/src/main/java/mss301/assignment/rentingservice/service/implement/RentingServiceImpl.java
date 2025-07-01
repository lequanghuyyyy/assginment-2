package mss301.assignment.rentingservice.service.implement;

import jakarta.transaction.Transactional;
import mss301.assignment.rentingservice.dtos.CarDTO;
import mss301.assignment.rentingservice.dtos.CustomerDTO;
import mss301.assignment.rentingservice.dtos.RentingRequest;
import mss301.assignment.rentingservice.dtos.RentingResponse;
import mss301.assignment.rentingservice.pojos.RentingDetail;
import mss301.assignment.rentingservice.pojos.RentingTransaction;
import mss301.assignment.rentingservice.repository.RentingDetailRepository;
import mss301.assignment.rentingservice.repository.RentingRepository;
import mss301.assignment.rentingservice.service.CarService;
import mss301.assignment.rentingservice.service.CustomerService;
import mss301.assignment.rentingservice.service.RentingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RentingServiceImpl implements RentingService {

    @Autowired
    private RentingRepository rentingRepository;

    @Autowired
    private RentingDetailRepository rentingDetailRepository;

    @Autowired
    CarService carService;

    @Autowired
    CustomerService customerService;

    @Override
    public List<RentingResponse> getAllRentingTransactions() {
        List<RentingTransaction> rentingTransactions = rentingRepository.findAll();
        List<RentingDetail> rentingDetails = rentingDetailRepository.findAll();
        List<RentingResponse> rentingResponses = new ArrayList<>();

        for (RentingTransaction transaction : rentingTransactions) {
            RentingResponse response = new RentingResponse();
            BeanUtils.copyProperties(transaction, response);

            for (RentingDetail detail : rentingDetails) {
                if (detail.getRentingTransaction().getRentingTransactionId() == transaction.getRentingTransactionId()) {
                    response.setCarId(detail.getCarId());
                    response.setStartDate(detail.getStartDate());
                    response.setEndDate(detail.getEndDate());
                    response.setPrice(detail.getPrice());
                }
            }
            rentingResponses.add(response);
        }

        return rentingResponses;
    }

    @Override
    public RentingResponse createRentingTransaction(RentingRequest request) {
        CarDTO carDTO = carService.getCarById(request.getCarId());
        CustomerDTO customerDTO = customerService.getCustomerById(request.getCustomerId());

        if (carDTO.getCarName() == null || customerDTO.getCustomerName() == null) {
            throw new RuntimeException("Cannot create renting transaction: car or customer not found.");
        }

        RentingTransaction transaction = new RentingTransaction();
        BeanUtils.copyProperties(request, transaction);
        transaction.setRentingDate(new Date());
//        int dayRented = (int) ((request.getEndDate().getTime() - request.getStartDate().getTime()) / (1000 * 60 * 60 * 24));
        RentingTransaction savedTransaction = rentingRepository.save(transaction);
        RentingDetail detail = new RentingDetail();
        detail.setRentingTransaction(savedTransaction);
        detail.setCarId(request.getCarId());
        detail.setStartDate(request.getStartDate());
        detail.setEndDate(request.getEndDate());
        detail.setPrice(carDTO.getCarRentingPricePerDay());
        rentingDetailRepository.save(detail);

        RentingResponse response = new RentingResponse();
        BeanUtils.copyProperties(savedTransaction, response);
        response.setRentingDate(transaction.getRentingDate());
        response.setCarId(detail.getCarId());
        response.setStartDate(detail.getStartDate());
        response.setEndDate(detail.getEndDate());
        response.setPrice(detail.getPrice());

        return response;
    }

    @Override
    public RentingResponse updateRentingTransaction(int rentingId, RentingRequest request) {
        CarDTO carDTO = carService.getCarById(request.getCarId());
        CustomerDTO customerDTO = customerService.getCustomerById(request.getCustomerId());

        if (carDTO == null || customerDTO == null) {
            throw new RuntimeException("Cannot update renting transaction: car or customer not found.");
        }

        RentingTransaction existingTransaction = rentingRepository.findById(rentingId).orElseThrow(() -> new RuntimeException("Renting transaction not found."));

        BeanUtils.copyProperties(request, existingTransaction);
        RentingTransaction savedTransaction = rentingRepository.save(existingTransaction);

        RentingDetail detail = rentingDetailRepository.findByRentingTransaction_RentingTransactionId(rentingId).orElseThrow(() -> new RuntimeException("Renting detail not found."));

        detail.setRentingTransaction(savedTransaction);
        detail.setCarId(request.getCarId());
        detail.setStartDate(request.getStartDate());
        detail.setEndDate(request.getEndDate());
        detail.setPrice(carDTO.getCarRentingPricePerDay());
        rentingDetailRepository.save(detail);

        RentingResponse response = new RentingResponse();
        BeanUtils.copyProperties(savedTransaction, response);
        response.setCarId(detail.getCarId());
        response.setStartDate(detail.getStartDate());
        response.setEndDate(detail.getEndDate());
        response.setPrice(detail.getPrice());

        return response;
    }
}
