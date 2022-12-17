package com.new_bank_app.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

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
    private int userId;
    @NotEmpty(message = "Filed cannot be empty")
    private String firstName;
    @NotEmpty(message = "Filed cannot be empty")
    private String lastName;
    @Email
    @NotEmpty(message = "Filed cannot be empty")
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", message = "Please enter valid email format.")
    private String email;
    @NotEmpty(message = "Filed cannot be empty")
    private String password;
    @PESEL
    private String pesel;
    private String dateOfBirth;
    private String city;
    private String zipCode;
    private String streetName;
    private String streetNumber;
    private String flatOrBuildingNumber;
    private String phoneNumber;
    private String token;
    private int verified;
    private LocalDate verifiedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
