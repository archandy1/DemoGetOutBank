package com.new_bank_app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transact {

    @Id
    private int transaction_id;
    private int account_id;
    private String transaction_type;
    private BigDecimal amount;
    private String source;
    private String status;
    private String reason_code;
    private LocalDateTime created_at;

}
