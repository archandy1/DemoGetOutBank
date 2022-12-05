package com.new_bank_app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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
    private int transaction_id;
    private String account_id;
    private String account_name;
    private int user_id;
    private String transaction_type;
    private BigDecimal amount;
    private String source;
    private String status;
    private LocalDateTime created_at;
}
