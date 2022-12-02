package com.new_bank_app.services;

import com.new_bank_app.models.Account;
import com.new_bank_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(int account_id) {
        return accountRepository.getAccountById(account_id);
    }
}
