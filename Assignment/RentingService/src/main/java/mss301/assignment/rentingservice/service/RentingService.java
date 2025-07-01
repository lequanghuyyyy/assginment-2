package mss301.assignment.rentingservice.service;

import mss301.assignment.rentingservice.dtos.RentingRequest;
import mss301.assignment.rentingservice.dtos.RentingResponse;

import java.util.List;

public interface RentingService {
    List<RentingResponse> getAllRentingTransactions();

    RentingResponse createRentingTransaction(RentingRequest request);

    RentingResponse updateRentingTransaction(int rentingId, RentingRequest request);
}
