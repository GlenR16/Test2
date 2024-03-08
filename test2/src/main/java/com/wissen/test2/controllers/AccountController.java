package com.wissen.test2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.wissen.test2.models.Account;
import com.wissen.test2.repositories.AccountRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/login")
    public Boolean postLogin(@RequestBody Account account) {
        Account _account = accountRepository.findById(account.getId()).orElse(null);
        if (_account == null) {
            return false;
        }
        if (_account.getPassword().equals(account.getPassword())) {
            return true;
        }
        return false;
    }

    @PostMapping("/register")
    public String postRegister(@RequestBody Account account) {
        if (accountRepository.findById(account.getId()).orElse(null) != null) {
            return "Account ID already exists!";
        }
        if (accountRepository.findByAccountNumber(account.getAccountNumber()) != null) {
            return "Account number already exists!";
        }
        account.setBalance(0);
        accountRepository.save(account);
        return "Account created successfully.";
    }
    
    @PutMapping("/changepwd/{id}/{oldPassword}/{newPassword}")
    public String putPassword(@PathVariable int id, @PathVariable String oldPassword, @PathVariable String newPassword) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            return "Account not found!";
        }
        if (!account.getPassword().equals(oldPassword)) {
            return "Old password is incorrect!";
        }
        if (account.getPassword().equals(newPassword)) {
            return "New password cannot be same as old password!";
        }
        account.setPassword(newPassword);
        accountRepository.save(account);
        return "Password changed successfully.";
    }

    @GetMapping("/balance/{accountNumber}")
    public long getBalance(@PathVariable int accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            return -1;
        }
        return account.getBalance();
    }
    
    @GetMapping("/below")
    public List<Account> getAccountsBelow(@RequestParam long balance) {
        return accountRepository.findByBalanceLessThan(balance);
    }

    @GetMapping("/above")
    public List<Account> getAccountsAbove(@RequestParam long balance) {
        return accountRepository.findByBalanceGreaterThan(balance);
    }
}
