package com.account;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public Account(String id, long balance) {
        this.id = id;
        this.balance = balance;
        this.logBalance.add(balance);
    }
    public Account(){}

    private int IdNum;
    private String id;
    private long balance;
    public List<Long> logBalance = new ArrayList<Long>();

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public int getIdNum() {
        return IdNum;
    }

    public void setIdNum(int idNum) {
        IdNum = idNum;
    }
}
