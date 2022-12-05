package com.new_bank_app.repository;

import com.new_bank_app.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository< User, Integer > {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User getUserDetails(@Param("email")  String email);

    @Query(value = "SELECT email FROM users WHERE email = :email", nativeQuery = true)
    String getUserEmail(@Param("email")  String email);

    @Query(value = "SELECT password FROM users WHERE email = :email", nativeQuery = true)
    String getUserPassword(@Param("email")  String email);

    @Query(value = "SELECT verified FROM users WHERE email = :email", nativeQuery = true)
    int isVerified(@Param("email")  String email);

    @Modifying
    @Query(value = "INSERT INTO users (first_name, last_name, email, password, pesel, date_of_birth, city, zip_code, street_name, street_number, flat_or_building_number, phone_number, token) VALUES" +
            "(:first_name, :last_name, :email, :password, :pesel, :date_of_birth, :city, :zip_code, :street_name, :street_number, :flat_or_building_number, :phone_number, :token)", nativeQuery = true)
    @Transactional
    void registerUser(@Param("first_name") String first_name,
                      @Param("last_name") String last_name,
                      @Param("email") String email,
                      @Param("password") String password,
                      @Param("pesel") String pesel,
                      @Param("date_of_birth") String date_of_birth,
                      @Param("city") String city,
                      @Param("zip_code") String zip_code,
                      @Param("street_name") String street_name,
                      @Param("street_number") String street_number,
                      @Param("flat_or_building_number") String flat_or_building_number,
                      @Param("phone_number") String phone_number,
                      @Param("token") String token);

    @Modifying
    @Query(value = "UPDATE users SET token=null, verified=1, verified_at=NOW(), updated_at=NOW() WHERE token= :token", nativeQuery = true)
    @Transactional
    void verifyAccount(@Param("token")String token);

    @Query(value = "SELECT token FROM users WHERE token = :token" , nativeQuery = true)
    String checkToken(@Param("token") String token);
}
