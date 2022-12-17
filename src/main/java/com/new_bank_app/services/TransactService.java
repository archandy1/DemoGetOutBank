package com.new_bank_app.services;

import com.new_bank_app.models.Account;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactService {

    private final AccountRepository accountRepository;
    private final TransactRepository transactRepository;
    private final AccountService accountService;



    @Autowired
    public TransactService(AccountRepository accountRepository, TransactRepository transactRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.transactRepository = transactRepository;
        this.accountService = accountService;
    }





    public void executeWithdraw(int accountId, BigDecimal withdrawAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUserId(), accountId);
        BigDecimal newBalance = currentBalance.subtract(withdrawAmountValue);
        String accountName = accountRepository.getUserAccountName(String.valueOf(accountId));
        transactRepository.logTransaction(accountId, user.getUserId(),accountName, "withdrawal",  withdrawAmountValue, "online", "success",  LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, accountId);

    }

    public void executeDeposit(int acc_id, BigDecimal depositAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUserId(), acc_id);
        BigDecimal newBalance = currentBalance.add(depositAmountValue);
        String accountName = accountRepository.getUserAccountName(String.valueOf(acc_id));
        transactRepository.logTransaction(acc_id, user.getUserId(), accountName,"deposit", depositAmountValue, "online", "success", LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, acc_id);
    }

    public void executeTransfer(int transferFromId, int transferToId, BigDecimal transferAmount, User user) {
        BigDecimal currentBalanceAccountFrom = accountRepository.getAccountBalance(user.getUserId(), transferFromId);
        BigDecimal currentBalanceAccountTo = accountRepository.getAccountBalance(user.getUserId(), transferToId);
        BigDecimal newBalanceAccountTransferringFrom = currentBalanceAccountFrom.subtract(transferAmount);
        BigDecimal newBalanceAccountTransferringTo = currentBalanceAccountTo.add(transferAmount);
        accountRepository.changeAccountBalanceById(newBalanceAccountTransferringFrom, transferFromId);
        accountRepository.changeAccountBalanceById(newBalanceAccountTransferringTo, transferToId);
    }
}
