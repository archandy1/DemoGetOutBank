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
            "(:firstName, :lastName, :email, :password, :pesel, :dateOfBirth, :city, :zipCode, :streetName, :streetNumber, :flatOrBuildingNumber, :phoneNumber, :token)", nativeQuery = true)
    @Transactional
    void registerUser(@Param("firstName") String firstName,
                      @Param("lastName") String lastName,
                      @Param("email") String email,
                      @Param("password") String password,
                      @Param("pesel") String pesel,
                      @Param("dateOfBirth") String dateOfBirth,
                      @Param("city") String city,
                      @Param("zipCode") String zipCode,
                      @Param("streetName") String streetName,
                      @Param("streetNumber") String streetNumber,
                      @Param("flatOrBuildingNumber") String flatOrBuildingNumber,
                      @Param("phoneNumber") String phoneNumber,
                      @Param("token") String token);

    @Modifying
    @Query(value = "UPDATE users SET token=null, verified=1, verified_at=NOW(), updated_at=NOW() WHERE token= :token", nativeQuery = true)
    @Transactional
    void verifyAccount(@Param("token")String token);

    @Query(value = "SELECT token FROM users WHERE token = :token" , nativeQuery = true)
    String checkToken(@Param("token") String token);
}
