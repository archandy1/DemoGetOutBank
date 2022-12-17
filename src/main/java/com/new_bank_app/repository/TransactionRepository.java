package com.new_bank_app.repository;

import com.new_bank_app.models.TransactionHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionHistory, Integer> {

    @Query(value = "SELECT * FROM transaction_history WHERE user_id = :userId", nativeQuery = true)
    List<TransactionHistory> getTransactionRecordsById(@Param("userId") int userId);
}
