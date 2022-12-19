package com.new_bank_app.controllers;

import com.new_bank_app.helpers.HTML;
import com.new_bank_app.helpers.Token;
import com.new_bank_app.mailMessenger.MailMessenger;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.UserRepository;
import com.new_bank_app.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private RegistrationService registrationService;


    //todo: new version
//    @PostMapping
//    public String register(@RequestBody RegistrationRequest request) {
//        return registrationService.register(request);
//    }
//
//     todo: old version
    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView getRegisterPage = new ModelAndView("register");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user,
                                 BindingResult result,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password,
                                 @RequestParam("pesel") String pesel,
                                 @RequestParam("dateOfBirth") String dateOfBirth,
                                 @RequestParam("city") String city,
                                 @RequestParam("zipCode") String zipCode,
                                 @RequestParam("streetName") String streetName,
                                 @RequestParam("streetNumber") String streetNumber,
                                 @RequestParam("flatOrBuildingNumber") String flatOrBuildingNumber,
                                 @RequestParam("phoneNumber") String phoneNumber) throws MessagingException {

        ModelAndView registrationPage = new ModelAndView("register");


        if (result.hasErrors() && confirm_password.isEmpty()) {
            registrationPage.addObject("confirm_pass", "Confirm field is required");
            return registrationPage;
        }

        if (!password.equals(confirm_password)) {
            registrationPage.addObject("passwordMisMatch", "passwords do not match");
            return registrationPage;
        }

        String token = Token.generateToken();

        String emailBody = HTML.htmlEmailTemplate(token);

        String encoded_password = BCrypt.hashpw(password, BCrypt.gensalt());

        userRepository.registerUser(
                firstName, lastName, email,
                encoded_password, pesel, dateOfBirth,
                city, zipCode, streetName, streetNumber,
                flatOrBuildingNumber, phoneNumber, token);

        MailMessenger.htmlEmailMessenger("bank@getoutbank.com", email, "Verify Account", emailBody);

        String successMessage = "Account registered successfully, please check your email and verify account";
        registrationPage.addObject("success", successMessage);

        return registrationPage;
    }
}



