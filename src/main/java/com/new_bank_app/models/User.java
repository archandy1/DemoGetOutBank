package com.new_bank_app.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private int user_id;
    @NotEmpty(message = "Filed cannot be empty")
    private String first_name;
    @NotEmpty(message = "Filed cannot be empty")
    private String last_name;
    @Email
    @NotEmpty(message = "Filed cannot be empty")
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", message = "Please enter valid email format.")
    private String email;
    @NotEmpty(message = "Filed cannot be empty")
    private String password;
    @PESEL
    private String pesel;
    private String date_of_birth;
    private String city;
    private String zip_code;
    private String street_name;
    private String street_number;
    private String flat_or_building_number;
    private String phone_number;
    private String token;
    private int verified;
    private LocalDate verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
