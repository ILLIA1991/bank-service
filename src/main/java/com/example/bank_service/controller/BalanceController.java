package com.example.bank_service.controller;

import com.example.bank_service.service.BankService;
import lombok.AllArgsConstructor;
import model.TransferBalance;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final  BankService bankService;



    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);


    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());

    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);

    }

}
