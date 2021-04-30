package com.company.dla.lab11.model.score;

import com.company.dla.lab11.Loggable;
import com.company.dla.lab11.model.account.Account;
import com.company.dla.lab11.model.money.Money;

@Loggable
@OperationLimit(limit = 5)
public class CreditScore extends Score {

    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }
    @MethodLimit(limit = 10)
    public Money getMoneyWithoutLess() {
        return super.getMoneyWithoutLess(); }

    @MethodLimit(limit = 10)
    public Money getMoney(double balanceLess) {
        return super.getMoney(balanceLess);
    }

    @MethodLimit(limit = 3)
    public void addMoney(Money money) {
        super.addMoney(money);
    }
}
