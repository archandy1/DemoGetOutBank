package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean checkWithdrawGreaterThanBalance(int account_id, BigDecimal withdrawAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);
        return (currentBalance.compareTo(withdrawAmountValue) < 0);
    }

    public boolean checkTransferGreaterThanBalance(int transferFromId, BigDecimal transferAmount,  User user) {
        BigDecimal currentBalanceAccountFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        return (currentBalanceAccountFrom.compareTo(transferAmount) < 0);

    }
}

