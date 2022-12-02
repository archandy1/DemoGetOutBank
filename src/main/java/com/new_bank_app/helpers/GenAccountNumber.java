package com.new_bank_app.helpers;

import org.iban4j.CountryCode;
import org.iban4j.Iban;

public class GenAccountNumber {

    public static String generateAccountNumber() {
        String setAccountNumber;
        Iban iban = new Iban.Builder().countryCode(CountryCode.PL).bankCode("696").buildRandom();
        setAccountNumber = iban.toString();
        return setAccountNumber;
    }
}


