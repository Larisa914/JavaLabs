package com.company.dla.lab11.model.score;

import com.company.dla.lab11.Loggable;
import com.company.dla.lab11.model.account.Account;
import com.company.dla.lab11.model.money.Money;

@Loggable
@OperationLimit(limit = 5)
public class CurrentScore extends Score {
    private final DebitScore debitScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebitScore debitScore) {
        super(balance, owner, number);
        this.debitScore = debitScore;

   }
    public DebitScore getDebitScore() {
        return debitScore;
    }

    @MethodLimit(limit= 5)
    public void addMoney(Money money) {
        if (money.getValue() > 1000000) {
            debitScore.addMoney(new Money(2000, debitScore.getBalance().getCurrency().getName()));
        }
        super.addMoney(money);

    }
    @MethodLimit(limit = 3)
    public Money getMoneyWithoutLess() {
        return super.getMoneyWithoutLess(); }

    @MethodLimit(limit = 3)
    public Money getMoney(double balanceLess) {
        return super.getMoney(balanceLess);
    }

}
