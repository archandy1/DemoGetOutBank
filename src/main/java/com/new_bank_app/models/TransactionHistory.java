package com.new_bank_app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "transaction_history")
public class TransactionHistory {

    @Id
    private int transactionId;
    private String accountId;
    private String accountName;
    private int userId;
    private String transactionType;
    private BigDecimal amount;
    private String source;
    private String status;
    private LocalDateTime createdAt;
}
