package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.repository.TransactRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactServiceTest {


    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactRepository transactRepository;

    @Test
    void executeWithdraw() {
        //given

        //when

        //then

    }

//    public void executeWithdraw(Long accountId, BigDecimal withdrawAmountValue, User user) {
//        BigDecimal currentBalance = accountRepository.getAccountBalance(user.getUserId(), accountId);
//        BigDecimal newBalance = currentBalance.subtract(withdrawAmountValue);
//        String accountName = accountRepository.getUserAccountName(String.valueOf(accountId));
//        transactRepository.logTransaction(accountId, user.getUserId(),accountName, "withdrawal",  withdrawAmountValue, "online", "success",  LocalDateTime.now());
//        accountRepository.changeAccountBalanceById(newBalance, accountId);
//    }


//    @Test
//    public void testWithdraw() {
//        BankAccount bankAccount = TestDataUtils.getBankAccount1();
//        Mockito.when(bankAccountService.getBankAccount(1L)).thenReturn(bankAccount);
//
//        withdrawService.withdraw(1L, BigDecimal.ONE);
//
//        Mockito.verify(transactionService, Mockito.times(1))
//                .executeWithdraw(Mockito.any(BankAccount.class), Mockito.eq(BigDecimal.ONE));
//    }

    @Test
    void executeDeposit() {
    }

    @Test
    void executeTransfer() {
    }
}