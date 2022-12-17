package com.new_bank_app.repository;

import com.new_bank_app.models.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository <Account, Integer> {

    @Query(value = "SELECT * FROM accounts WHERE user_id = :userId ", nativeQuery = true)
    List<Account> getUserAccountsById(@Param("userId")int userId);


    @Query(value = "SELECT * FROM accounts WHERE account_id = :accountId ", nativeQuery = true)
    Account getAccountById(@Param("accountId")int accountId);

    @Query(value = "SELECT sum(balance) FROM accounts WHERE user_id = :userId ", nativeQuery = true)
    BigDecimal getTotalBalance(@Param("userId")int userId);

    @Query(value = "SELECT balance FROM accounts WHERE user_id = :userId AND account_id = :accountId", nativeQuery = true)
    BigDecimal getAccountBalance(@Param("userId")int userId, @Param("accountId") int accountId);

    @Query(value = "SELECT account_name FROM accounts WHERE account_id = :accountId", nativeQuery = true)
    String getUserAccountName(@Param("accountId") String accountId);


    @Modifying
    @Query(value = "UPDATE accounts SET balance = :new_balance WHERE account_id = :accountId", nativeQuery = true)
    @Transactional
    void changeAccountBalanceById(
                                  @Param("new_balance") BigDecimal new_balance,
                                  @Param("accountId") int accountId);

    @Modifying
    @Query(value = "INSERT INTO accounts(user_id, account_number, account_name, account_type) VALUES " +
            "(:userId, :accountNumber, :accountName, :accountType)" , nativeQuery = true)
    @Transactional
    void createBankAccount(@Param("userId") int userId,
                           @Param("accountNumber") String accountNumber,
                           @Param("accountName") String accountName,
                           @Param("accountType") String accountType);
}
