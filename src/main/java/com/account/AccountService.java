package com.account;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    public static final int Max =100;
    public static int countId = 0;
    public Map<String, Account> accountMap = new HashMap<String, Account>();
    public String[] log = new String[Max];
    public int logIndex = 0;

    public void addAccount(Account account)
    {
        accountMap.put(account.getId(), account);
        account.setIdNum(countId++);
    }


    public Account findAccount(String id)
    {
        return this.accountMap.get(id);
    }

    public void transfer(Account from, Account to, long amount)
    {
        from.setBalance(from.getBalance()-amount);
        to.setBalance(to.getBalance()+amount);
        log[logIndex++] = from.getId() + " " + to.getId() + " " + amount + " " + "송금" + " " + "12.24";
        from.logBalance.add(from.getBalance());
        to.logBalance.add(to.getBalance());
    }

    public void debit (Account account, long amount)
    {
        account.setBalance(account.getBalance()-amount);
        log[logIndex++] = account.getId() + " " + "-" + " " + amount + " " + "출금" + " " + "12.24";
        account.logBalance.add(account.getBalance());
    }

    public void credit(Account account, long amount)
    {
        account.setBalance(account.getBalance()+amount);
        log[logIndex++] = account.getId() + " " + "-" + " " + amount + " " + "입금" + " " + "12.24";
        System.out.println("gdgdgd");
        account.logBalance.add(account.getBalance());
    }



}
