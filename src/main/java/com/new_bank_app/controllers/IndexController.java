package com.new_bank_app.controllers;


import com.new_bank_app.repository.UserRepository;
import com.new_bank_app.type.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    private final UserRepository userRepository;
    private final Attribute attribute;

    @Autowired
    public IndexController(UserRepository userRepository, Attribute attribute) {
        this.userRepository = userRepository;
        this.attribute = attribute;
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
    public ModelAndView getVerify(@RequestParam("token") String token) {

        ModelAndView getVerifyPage;
        String dbToken = userRepository.checkToken(token);

        if (dbToken == null) {
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject(attribute.ERROR, "This session Has Expired");
            return getVerifyPage;
        }

        userRepository.verifyAccount(token);
        getVerifyPage = new ModelAndView("login");
        getVerifyPage.addObject(attribute.SUCCESS, "Account Verified Successfully, please login.");
        return getVerifyPage;
    }
}
