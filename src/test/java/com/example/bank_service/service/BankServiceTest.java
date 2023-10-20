package com.example.bank_service.service;

import com.example.bank_service.repository.BalanceRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);

    @Test
    void getBalance() {
        final BigDecimal balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }
    @Test
    void addMoney() {
        final BigDecimal balance = bankService.addMoney(1L, BigDecimal.ONE);

        assertEquals(balance, BigDecimal.valueOf(11));
    }
}