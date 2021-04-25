package com.company.dla.lab5.model.score;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.money.Money;

public class CurrentScore extends Score{
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    public void addMoney(Money money){
        if (money.getValue() > 1000000) {
           debetScore.addMoney(new Money(2000, debetScore.getBalance().getCurrency().getName()));
        }
        super.addMoney(money);

    }

}
