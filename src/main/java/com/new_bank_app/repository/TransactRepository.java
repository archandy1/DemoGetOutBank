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
            "VALUES (:accountId, :userId, :accountName, :transactionType, :amount, :source, :status, :createdAt)", nativeQuery = true)
    void logTransaction(@Param("accountId") int accountId,
                        @Param("userId") int userId,
                        @Param("accountName") String accountName,
                        @Param("transactionType") String transactionType,
                        @Param("amount") BigDecimal amount,
                        @Param("source") String source,
                        @Param("status") String status,
                        @Param("createdAt") LocalDateTime createdAt);
}

