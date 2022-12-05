package com.new_bank_app.controllers;

import com.new_bank_app.helpers.GenAccountNumber;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.services.UserService;
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

    @Autowired
    public AccountController(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name") String accountName,
                                @RequestParam("account_type") String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {

        if(accountName.isEmpty() || accountType.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "account name and type cannot be empty");
            return "redirect:/app/dashboard";
        }

        User user = userService.getUser(session);

        String accountNumber = GenAccountNumber.generateAccountNumber();

        accountRepository.createBankAccount(user.getUser_id(), accountNumber, accountName, accountType);
        redirectAttributes.addFlashAttribute("success", "account created.");
        //
        return "redirect:/app/dashboard";
    }
}
