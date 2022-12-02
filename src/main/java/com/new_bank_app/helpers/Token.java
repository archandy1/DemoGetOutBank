package com.new_bank_app.helpers;

import java.util.UUID;

public class Token {

    public static String generateToken() {
        String token = UUID.randomUUID().toString();
        return token;
    }
}
