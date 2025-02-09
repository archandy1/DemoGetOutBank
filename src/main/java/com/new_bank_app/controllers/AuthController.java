package com.new_bank_app.controllers;

import com.new_bank_app.helpers.Token;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.UserRepository;
import com.new_bank_app.type.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {


    private final UserRepository userRepository;
    private final Attribute attribute;
    @Autowired

    public AuthController(UserRepository userRepository, Attribute attribute) {
        this.userRepository = userRepository;
        this.attribute = attribute;
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView getLoginPage = new ModelAndView("login");
        String token = Token.generateToken();
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("token") String token,
                        Model model,
                        HttpSession session) {

        if (email.isEmpty() || password.isEmpty()) {
            model.addAttribute(attribute.ERROR, "Username or password cannot be empty.");
            return "login";
        }

        String getEmailInDatabase = userRepository.getUserEmail(email);

        if (getEmailInDatabase != null) {
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);
            if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
                model.addAttribute(attribute.ERROR, "Incorrect username or password");
                return "login";
            }
        } else {
            model.addAttribute(attribute.ERROR, "Unexpected authentication error");
            return "error";
        }

        int verified = userRepository.isVerified(getEmailInDatabase);
        if (verified != 1) {
            model.addAttribute(attribute.ERROR, "This account is not verified. Please check your email and verify account.");
            return "login";
        }

        User user = userRepository.getUserDetails(getEmailInDatabase);
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "logged out successfully");
        return "redirect:/login";
    }
}
