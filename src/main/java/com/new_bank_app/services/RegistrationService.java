package com.new_bank_app.services;

import com.new_bank_app.controllers.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "it works";
    }
}
