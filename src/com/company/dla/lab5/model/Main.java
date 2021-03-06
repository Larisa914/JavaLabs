package com.company.dla.lab5.model;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.account.Principal;
import com.company.dla.lab5.model.money.Money;
import com.company.dla.lab5.model.score.CreditScore;
import com.company.dla.lab5.model.score.CurrentScore;
import com.company.dla.lab5.model.score.DebitScore;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println(" Lab 5 ");
        Account account = new Account(new Principal("John", "Smith", "A.", (short) 45), "smith", "123");

        CurrentScore currentScore = new CurrentScore(new Money(1000, "USD"), account, 12345,
                new DebitScore(new Money(100, "USD"), account, 12300,
                        new CreditScore(new Money(10, "USD"), account, 12000)));

        System.out.println("Current Score: " + currentScore.getNumber() + ": " + currentScore.getBalance().getValue()+" "+currentScore.getBalance().getCurrency().getName());
        System.out.println("  Debit Score: " + currentScore.getDebitScore().getNumber() + ":" + currentScore.getDebitScore().getBalance().getValue());
        System.out.println(" Credit Score: " + currentScore.getDebitScore().getCreditScore().getNumber() + ":" + currentScore.getDebitScore().getCreditScore().getBalance().getValue());
        System.out.println("======");
        System.out.println("  Debit Score BALANCE: " + currentScore.getDebitScore().getBalance().getValue());

    }
}
