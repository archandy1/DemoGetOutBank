package com.new_bank_app.controllers;


import com.new_bank_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    private final UserRepository userRepository;

    @Autowired
    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        return getIndexPage;
    }

    @GetMapping("/error")
    public ModelAndView getError() {
        ModelAndView getErrorPage = new ModelAndView("error");
        getErrorPage.addObject("PageTitle", "Error");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token") String token, @RequestParam("code") String code) {

        ModelAndView getVerifyPage;
        String dbToken = userRepository.checkToken(token);

        if (dbToken == null) {
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error", "This session Has Expired");
            return getVerifyPage;
        }

        userRepository.verifyAccount(token, code);
        getVerifyPage = new ModelAndView("login");
        getVerifyPage.addObject("success", "Account Verified Successfully, please login.");
        return getVerifyPage;
    }
}
