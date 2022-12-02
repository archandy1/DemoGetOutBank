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
@Table(name = "v_payments")
public class PaymentHistory {

    @Id
    private int payment_id;
    private int account_id;
    private int user_id;
    private String beneficiary;
    private String beneficiary_acc_no;
    private BigDecimal amount;
    private String  status;
    private String reference_no;
    private String reason_code;
    private LocalDateTime created_at;

}
