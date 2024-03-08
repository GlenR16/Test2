package com.wissen.test2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.wissen.test2.models.Transaction;
import com.wissen.test2.repositories.AccountRepository;
import com.wissen.test2.repositories.TransactionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;
    
    @PostMapping("/transfer")
    public String postTransaction(@RequestBody Transaction transaction) {
        if (transaction.getAmount() <= 0 || transactionRepository.findById(transaction.getId()).orElse(null) != null){
            return "Invalid transaction!";
        }
        if (accountRepository.findByAccountNumber(transaction.getFromAccount()) == null) {
            return "From account not found!";
        }
        if (accountRepository.findByAccountNumber(transaction.getToAccount()) == null) {
            return "To account not found!";
        }
        if (accountRepository.findByAccountNumber(transaction.getFromAccount()).getBalance() < transaction.getAmount()) {
            return "Insufficient balance!";
        }
        accountRepository.findByAccountNumber(transaction.getFromAccount()).setBalance(accountRepository.findByAccountNumber(transaction.getFromAccount()).getBalance() - transaction.getAmount());
        accountRepository.findByAccountNumber(transaction.getToAccount()).setBalance(accountRepository.findByAccountNumber(transaction.getToAccount()).getBalance() + transaction.getAmount());
        accountRepository.save(accountRepository.findByAccountNumber(transaction.getFromAccount()));
        accountRepository.save(accountRepository.findByAccountNumber(transaction.getToAccount()));
        transactionRepository.save(transaction);
        return "Transaction successful!";
    }

    @GetMapping("")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
