package com.company.dla.lab5.model.score;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.money.Money;

public class CurrentScore extends Score {
    private final DebitScore debitScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebitScore debitScore) {
        super(balance, owner, number);
        this.debitScore = debitScore;
    }

    public void addMoney(Money money) {
        if (money.getValue() > 1000000) {
            debitScore.addMoney(new Money(2000, debitScore.getBalance().getCurrency().getName()));
        }
        super.addMoney(money);

    }

}
