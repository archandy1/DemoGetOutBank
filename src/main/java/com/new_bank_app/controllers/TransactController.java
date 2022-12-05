package com.new_bank_app.controllers;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.TransactRepository;
import com.new_bank_app.services.TransactService;
import com.new_bank_app.services.UserService;
import com.new_bank_app.services.ValidationService;
import com.new_bank_app.type.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {


    private final TransactRepository transactRepository;
    private final ValidationService validationService;
    private final TransactService transactService;
    private final UserService userService;
    private final Attribute attribute;

    @Autowired
    public TransactController(TransactRepository transactRepository, ValidationService validationService, TransactService transactService, UserService userService, Attribute attribute) {
        this.transactRepository = transactRepository;
        this.validationService = validationService;
        this.transactService = transactService;
        this.userService = userService;
        this.attribute = attribute;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount") String depositAmount,
                          @RequestParam("account_id") String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (depositAmount.isEmpty() || accountID.isEmpty()) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Deposit amount cannot be empty.");
            return "redirect:/app/dashboard";
        }

        User user = userService.getUser(session);

        int acc_id = Integer.parseInt(accountID);
        BigDecimal depositAmountValue = BigDecimal.valueOf(Double.parseDouble(depositAmount));

        if (depositAmountValue.compareTo(BigDecimal.ZERO) <= 0) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Deposit amount cannot be zero.");
            return "redirect:/app/dashboard";
        }
        transactService.executeDeposit(acc_id, depositAmountValue, user);
        redirectAttributes.addFlashAttribute(attribute.SUCCESS, "Amount deposited successfully.");
        return "redirect:/app/dashboard";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from") String transfer_from,
                           @RequestParam("transfer_to") String transfer_to,
                           @RequestParam("transfer_amount") String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        if (transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()) {
            String transferErrorMsg = "You must select account from, account to, and transfer amount to execute transfer";
            redirectAttributes.addFlashAttribute(attribute.ERROR, transferErrorMsg);
            return "redirect:/app/dashboard";
        }

        User user = userService.getUser(session);

        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        BigDecimal transferAmount = BigDecimal.valueOf(Double.parseDouble(transfer_amount));

        if (transfer_from.equals(transfer_to)) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "You cannot execute transfer into the same account");
            return "redirect:/app/dashboard";
        }

        if (transferAmount.compareTo(BigDecimal.ZERO) <= 0) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Transfer amount cannot be zero.");
            return "redirect:/app/dashboard";
        }

        boolean isTransferGreaterThanBalance = validationService.checkTransferGreaterThanBalance(transferFromId, transferAmount, user);
        if (isTransferGreaterThanBalance) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Insufficient funds to execute transfer.");
            return "redirect:/app/dashboard";
        } else {
            transactService.executeTransfer(transferFromId, transferToId, transferAmount, user);
            transactRepository.logTransaction(transferFromId, user.getUser_id(), "transfer", transferAmount, "online", attribute.SUCCESS, LocalDateTime.now());
            redirectAttributes.addFlashAttribute(attribute.SUCCESS, "Transfer success");
        }
        return "redirect:/app/dashboard";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdrawal_amount") String withdrawal_amount,
                           @RequestParam("account_id") String accountID,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        if (withdrawal_amount.isEmpty() || accountID.isEmpty()) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Withdraw amount cannot be empty.");
            return "redirect:/app/dashboard";
        }
        int account_id = Integer.parseInt(accountID);
        BigDecimal withdrawAmountValue = BigDecimal.valueOf(Double.parseDouble(withdrawal_amount));

        User user = userService.getUser(session);

        if (withdrawAmountValue.compareTo(BigDecimal.ZERO) <= 0) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Withdraw amount cannot be zero.");
            return "redirect:/app/dashboard";
        }

        boolean isWithdrawGreaterThanBalance = validationService.checkWithdrawGreaterThanBalance(account_id, withdrawAmountValue, user);
        if (isWithdrawGreaterThanBalance) {
            redirectAttributes.addFlashAttribute(attribute.ERROR, "Insufficient funds to execute withdrawal.");
            return "redirect:/app/dashboard";
        } else {
            transactService.executeWithdraw(account_id, withdrawAmountValue, user);
        }
        return "redirect:/app/dashboard";
    }
}
