package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.repository.PaymentRepository;
import com.new_bank_app.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TransactRepository transactRepository;
    @Autowired
    private AccountService accountService;

    public boolean checkWithdrawGreaterThanBalance(int account_id, BigDecimal withdrawAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);
        return (currentBalance.compareTo(withdrawAmountValue) < 0);
    }

    public boolean checkTransferGreaterThanBalance(int transferFromId, BigDecimal transferAmount,  User user) {
        BigDecimal currentBalanceAccountFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        return (currentBalanceAccountFrom.compareTo(transferAmount) < 0);

    }

    public boolean checkPaymentGreaterThanBalance(int accountId, BigDecimal paymentAmount, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), accountId);
        return (currentBalance.compareTo(paymentAmount) < 0);
    }
}

