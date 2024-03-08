package com.wissen.test2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    private int id;
    private int fromAccount;
    private int toAccount;
    private String ifsc;
    private long amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Transaction() {
    }

    public Transaction(int id, int fromAccount, int toAccount, String ifsc, long amount) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.ifsc = ifsc;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", ifsc=" + ifsc + ", amount=" + amount + "]";
    }
}
