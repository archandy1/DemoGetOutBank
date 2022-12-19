package com.new_bank_app.controllers;

import com.new_bank_app.models.Account;
import com.new_bank_app.models.TransactionHistory;
import com.new_bank_app.models.User;
import com.new_bank_app.repository.AccountRepository;
import com.new_bank_app.repository.TransactionRepository;
import com.new_bank_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    User user;

    private final AccountRepository accountRepository;
    private final TransactionRepository transactHistoryRepository;
    private final UserService userService;

    @Autowired
    public AppController(AccountRepository accountRepository, TransactionRepository transactHistoryRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.transactHistoryRepository = transactHistoryRepository;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        User user = userService.getUser(session);

        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUserId());

        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUserId());

        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }


    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session) {

        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        User user = userService.getUser(session);

        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUserId());
        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;
    }
}
