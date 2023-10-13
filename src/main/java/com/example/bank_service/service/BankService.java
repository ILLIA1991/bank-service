package com.example.bank_service.service;

import model.TransferBalance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService {

    public BigDecimal getBalance(Long accountId) {
        return null;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance) {
    }
}
