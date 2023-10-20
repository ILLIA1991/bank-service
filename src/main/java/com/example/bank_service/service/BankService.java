package com.example.bank_service.service;

import com.example.bank_service.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import model.TransferBalance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepository balanceRepository;

    public BigDecimal getBalance(Long accountId) {
      BigDecimal balance = balanceRepository.getBalanceForId(accountId);
      if (balance == null) {
          throw new IllegalArgumentException();
      }
      return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = balanceRepository.getBalanceForId(to);
        if (currentBalance == null) {
             balanceRepository.save(to,amount);
            return amount;
        } else {
            final BigDecimal updated = currentBalance.add(amount);
            balanceRepository.save(to, updated);
            return updated;
        }
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = balanceRepository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = balanceRepository.getBalanceForId(transferBalance.getTo());
        if(fromBalance == null || toBalance == null) throw new IllegalArgumentException();
        if(transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("No money");
        BigDecimal updateFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updateToBalance = toBalance.add(transferBalance.getAmount());
        balanceRepository.save(transferBalance.getFrom(), updateFromBalance);
        balanceRepository.save(transferBalance.getTo(), updateToBalance);
    }
}
