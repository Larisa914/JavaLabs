package com.company.dla.lab5.model.score;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.money.Money;

public class DebetScore extends Score{
    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    //проверка доступа к операциям по счету
    //Наличие кредитного счета с балансом менее минус 20 000 запрещает
    //работу с дебетовым счетом
    public boolean checkBefore(){
        if (this.creditScore.getMoneyWithoutLess().getValue()<-20000){
            System.out.println("Наличие кредитного счета с балансом < - 20 000 запрещает \n" +
                    "работу с дебетовым счетом");
            return false;
        }
        return true;
    }

    public Money getMoney(double balanceLess){
        // проверка баланса кредитного счета
        if(! checkBefore()) {
            throw new IllegalArgumentException("No check!");
        }
        // проверка баланса дебетового счета на наличиче необходимой суммы
        if(this.getMoneyWithoutLess().getValue() < balanceLess) {
            throw new IllegalArgumentException("You have no so much!");
       }
        return super.getMoney(balanceLess);
    }

    //public void addMoney(Money money){
    //    super.addMoney(money);
    //}

}
