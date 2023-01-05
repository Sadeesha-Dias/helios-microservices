package com.helios.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class HeliosFraudCheckService {

    private final HeliosFraudCheckHistoryRepository heliosFraud;

    public HeliosFraudCheckService(HeliosFraudCheckHistoryRepository heliosFraud) {
        this.heliosFraud = heliosFraud;
    }

    public boolean isCustomerFraud(Integer customerId){
        heliosFraud.save(
                HeliosFraudCheckHistory.builder()
                        .heliosCustomerId(customerId)
                        .isFraud(false)
                        .userCreatedAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
