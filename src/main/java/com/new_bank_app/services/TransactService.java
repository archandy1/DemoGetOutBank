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

    public void executeWithdraw(int account_id, BigDecimal withdrawAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);
        Account account = accountService.getAccount(account_id);
        BigDecimal newBalance = currentBalance.subtract(withdrawAmountValue);
        transactRepository.logTransaction(account_id, user.getUser_id(),"withdrawal",  withdrawAmountValue, "online", "success",  LocalDateTime.now());
        accountRepository.changeAccountBalanceById(newBalance, account_id);
    }

    public void executeDeposit(int acc_id, BigDecimal depositAmountValue, User user) {
        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
        Account account = accountService.getAccount(acc_id);
        BigDecimal newBalance = currentBalance.add(depositAmountValue);
        transactRepository.logTransaction(acc_id, user.getUser_id(), "deposit", depositAmountValue, "online", "success", LocalDateTime.now());
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
}
