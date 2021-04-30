package com.company.dla.lab11;

import com.company.dla.lab11.model.account.Account;
import com.company.dla.lab11.model.account.Principal;
import com.company.dla.lab11.model.money.Money;
import com.company.dla.lab11.model.score.CreditScore;
import com.company.dla.lab11.model.score.CurrentScore;
import com.company.dla.lab11.model.score.DebitScore;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println(" Lab 11 ");
        Account account = new Account(new Principal("John", "Smith", "A.", (short) 45), "smith", "123");

        CurrentScore currentScore = new CurrentScore(new Money(3000, "USD"), account, 30345,
                new DebitScore( new Money(300, "USD"), account, 33300,
                        new CreditScore(new Money(600, "USD"), account, 30001)));

        //System.out.println("Current Score: " + currentScore.getNumber() + ": " + currentScore.getBalance().getValue()+" "+currentScore.getBalance().getCurrency().getName());
        //System.out.println("  Debit Score: " + currentScore.getDebitScore().getNumber() + ":" + currentScore.getDebitScore().getBalance().getValue());
        //System.out.println(" Credit Score: " + currentScore.getDebitScore().getCreditScore().getNumber() + ":" + currentScore.getDebitScore().getCreditScore().getBalance().getValue());
        System.out.println("ОПЕРАЦИИ БАНКОМАТА:");
        System.out.println(" Credit Score BALANCE: " + currentScore.getDebitScore().getCreditScore().getMoneyWithoutLess().getValue());
        System.out.println("  Debit Score BALANCE: " + currentScore.getDebitScore().getMoneyWithoutLess().getValue());

        //currentScore.getDebitScore().addMoney(new Money(300, "USD"));
        currentScore.addMoney(new Money(120, "USD"));
        currentScore.getDebitScore().addMoney(new Money(300, "USD"));
        //System.out.println("  Debit Score BALANCE: " + currentScore.getDebitScore().getBalance().getValue());
        //System.out.println("  Debit Score BALANCE: " + currentScore.getDebitScore().getMoneyWithoutLess().getValue());
        System.out.println("  Debit Score BALANCE: " + currentScore.getBalance().getValue());
        System.out.println("  Debit Score BALANCE: " + currentScore.getMoneyWithoutLess().getValue());

    }

}