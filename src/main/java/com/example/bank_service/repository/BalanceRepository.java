package com.example.bank_service.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BalanceRepository {

    private final Map<Long, BigDecimal> storage = new HashMap<>();
}
