package com.new_bank_app.repository;

import com.new_bank_app.models.PaymentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends CrudRepository <PaymentHistory, Integer> {

    @Query(value = "SELECT * FROM v_payments WHERE user_id = :user_id", nativeQuery = true)
    List<PaymentHistory> getPaymentHistoryById(@Param("user_id") int user_id);
}
