package com.company.dla.lab5.model.score;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.money.Money;

public class CreditScore extends Score {

    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

}
