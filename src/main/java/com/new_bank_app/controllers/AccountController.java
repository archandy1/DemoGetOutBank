package com.new_bank_app.controllers;

import com.new_bank_app.helpers.GenAccountNumber;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.services.UserService;
import com.new_bank_app.type.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository accountRepository;
    private final UserService userService;
    private final Attribute attribute;


    @Autowired
    public AccountController(AccountRepository accountRepository, UserService userService, Attribute attribute) {
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.attribute = attribute;
    }

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("accountName") String accountName,
                                @RequestParam("accountType") String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {

        if(accountName.isEmpty() || accountType.isEmpty()) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "account name and type cannot be empty");
            return "redirect:/app/dashboard";
        }
//     todo: old
        User user = userService.getUser(session);

//        todo: new
//        User user = userService.loadUserByUsername(email);

        String accountNumber = GenAccountNumber.generateAccountNumber();

        accountRepository.createBankAccount(user.getUserId(), accountNumber, accountName, accountType);
        redirectAttributes.addFlashAttribute(attribute.SUCCESS, "account created.");
        //
        return "redirect:/app/dashboard";
    }
}
