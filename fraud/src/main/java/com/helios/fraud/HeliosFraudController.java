package com.helios.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/helios/fraud-check")
public class HeliosFraudController {

    private final HeliosFraudCheckService fraudCheckService;

    public HeliosFraudController(HeliosFraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{heliosCustomerId}")
    public FraudCheckResult isFraud(@PathVariable("heliosCustomerId") Integer customerId){
        boolean checkedResult =  fraudCheckService.isCustomerFraud(customerId);
        return new FraudCheckResult(checkedResult);
    }
}
