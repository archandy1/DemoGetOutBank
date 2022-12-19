package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationService {

    private final AccountRepository accountRepository;
    @Autowired
    public ValidationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean checkWithdrawGreaterThanBalance(Long accountId, BigDecimal withdrawAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUserId(), accountId);
        return (currentBalance.compareTo(withdrawAmountValue) < 0);
    }

    public boolean checkTransferGreaterThanBalance(Long transferFromId, BigDecimal transferAmount,  User user) {
        BigDecimal currentBalanceAccountFrom = accountRepository.getAccountBalance(user.getUserId(), transferFromId);
        return (currentBalanceAccountFrom.compareTo(transferAmount) < 0);
    }
}

