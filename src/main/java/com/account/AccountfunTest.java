package com.account;

public class AccountfunTest {

    public static void main(String args[]){

        Account a = new Account("jiha",13000);
        Account b = new Account("haha",8000);

        AccountService accountService = new AccountService();

        accountService.addAccount(a);
        accountService.addAccount(b);
        accountService.credit(a,1000);
        accountService.debit(b,3000);
        accountService.transfer(a,b,5000);
        accountService.transfer(b,a,5000);
        accountService.transfer(a,b,5000);
        accountService.transfer(b,a,5000);


        System.out.print("a의 돈은 : " + a.getBalance());
        System.out.print("b의 돈은 : " + b.getBalance());

    }


}
