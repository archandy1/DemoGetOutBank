package com.new_bank_app.models;

import com.new_bank_app.type.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User implements UserDetails {

    public User(String firstName,
                String lastName,
                String email,
                String password,
                String pesel,
                String dateOfBirth,
                String city,
                String zipCode,
                String streetName,
                String streetNumber,
                String flatOrBuildingNumber,
                String phoneNumber,
                String token,
                int verified,
                LocalDate verifiedAt,
                LocalDateTime createdAt,
                LocalDateTime updatedAt,
                UserRole userRole,
                Boolean locked,
                Boolean enabled) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.flatOrBuildingNumber = flatOrBuildingNumber;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.verified = verified;
        this.verifiedAt = verifiedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userRole = userRole;
        this.locked = locked;
        this.enabled = enabled;
    }


    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
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
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Type(type="yes_no")
    private Boolean locked = false;
    @Type(type="yes_no")
    private Boolean enabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
