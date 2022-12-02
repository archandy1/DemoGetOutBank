package com.new_bank_app.services;

import com.new_bank_app.models.Account;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.repository.PaymentRepository;
import com.new_bank_app.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TransactRepository transactRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ValidationService validationService;

    public void executeWithdraw(int account_id, BigDecimal withdrawAmountValue, User user) {
        // could be in separate method, withdraw and deposit are using it
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);
        // never used?
        Account account = accountService.getAccount(account_id);
        BigDecimal newBalance = currentBalance.subtract(withdrawAmountValue);
        transactRepository.logTransaction(account_id, "withdrawal", withdrawAmountValue, "online", "success", "Withdraw success", LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, account_id);
    }

    public void executeDeposit(int acc_id, BigDecimal depositAmountValue, User user) {
        // could be in separate method, withdraw and deposit are using it
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
        // never used?
        Account account = accountService.getAccount(acc_id);
        BigDecimal newBalance = currentBalance.add(depositAmountValue);
        transactRepository.logTransaction(acc_id, "deposit", depositAmountValue, "online", "success", "Deposit success", LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, acc_id);
    }

    public void executeTransfer(int transferFromId, int transferToId, BigDecimal transferAmount, User user) {
        BigDecimal currentBalanceAccountFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        BigDecimal currentBalanceAccountTo = accountRepository.getAccountBalance(user.getUser_id(), transferToId);
        BigDecimal newBalanceAccountTransferringFrom = currentBalanceAccountFrom.subtract(transferAmount);
        BigDecimal newBalanceAccountTransferringTo = currentBalanceAccountTo.add(transferAmount);
        accountRepository.changeAccountBalanceById(newBalanceAccountTransferringFrom, transferFromId);
        accountRepository.changeAccountBalanceById(newBalanceAccountTransferringTo, transferToId);
    }

    public void executePayment(int accountId, BigDecimal paymentAmount,  User user, String beneficiary, String reference, String account_number) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), accountId);
        BigDecimal newBalance = currentBalance.subtract(paymentAmount);
        String reasonCode = "Payment Processed Successfully.";
        paymentRepository.makePayment(accountId, beneficiary, account_number, paymentAmount, reference, "success", reasonCode, LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, accountId);
        transactRepository.logTransaction(accountId, "payment", paymentAmount, "online", "success", "Payment  successful.", LocalDateTime.now());
    }
}
