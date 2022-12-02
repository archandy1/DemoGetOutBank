package com.new_bank_app.repository;

import com.new_bank_app.models.Transact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface TransactRepository extends CrudRepository<Transact, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transaction_history(account_id, transaction_type, amount, source, status, reason_code, created_at)" +
            "VALUES (:account_id, :transaction_type, :amount, :source, :status, :reason_code, :created_at)", nativeQuery = true)
    void logTransaction(@Param("account_id") int account_id,
                        @Param("transaction_type") String transaction_type,
                        @Param("amount") BigDecimal amount,
                        @Param("source") String source,
                        @Param("status") String status,
                        @Param("reason_code") String reason_code,
                        @Param("created_at") LocalDateTime created_at);
}

