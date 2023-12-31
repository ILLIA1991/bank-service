package com.example.bank_service.controller;

import com.example.bank_service.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.TransferBalance;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final  BankService bankService;



    @GetMapping("/{{accountId}}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);


//        TransferBalance transferBalance = new ObjectMapper().readValue("{\n" +
//                "\"from\":2,\n" +
//                "\"to\":3,\n" +
//                "\"amount\":300\n" +
//                "}", TransferBalance.class);

    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());

    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "I'm broke!!!";


    }

}
