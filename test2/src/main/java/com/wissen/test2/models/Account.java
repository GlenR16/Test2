package com.wissen.test2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private int id;
    private int accountNumber;
    private String name;
    private String type;
    private long mobile;
    private long balance;
    private String ifsc;
    private String password;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Account() {
    }

    public Account(int id, int accountNumber, String name, String type, long mobile, long balance, String ifsc, String password) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.type = type;
        this.mobile = mobile;
        this.balance = balance;
        this.ifsc = ifsc;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", name=" + name + ", type=" + type
                + ", mobile=" + mobile + ", balance=" + balance + ", ifsc=" + ifsc + ", password=" + password + "]";
    }

}
