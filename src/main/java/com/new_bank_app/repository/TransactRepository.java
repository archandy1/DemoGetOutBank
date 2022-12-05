package com.new_bank_app.repository;

import com.new_bank_app.models.TransactionHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface TransactRepository extends CrudRepository<TransactionHistory, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transaction_history(account_id, user_id, account_name, transaction_type, amount, source, status, created_at)" +
            "VALUES (:account_id, :user_id, :account_name, :transaction_type, :amount, :source, :status, :created_at)", nativeQuery = true)
    void logTransaction(@Param("account_id") int account_id,
                        @Param("user_id") int user_id,
                        @Param("account_name") String account_name,
                        @Param("transaction_type") String transaction_type,
                        @Param("amount") BigDecimal amount,
                        @Param("source") String source,
                        @Param("status") String status,
                        @Param("created_at") LocalDateTime created_at);
}

