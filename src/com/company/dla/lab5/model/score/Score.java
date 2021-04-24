package com.company.dla.lab5.model.score;

import com.company.dla.lab5.model.account.Account;
import com.company.dla.lab5.model.money.Money;
import com.company.dla.lab5.model.money.MoneyInterface;

public abstract class Score implements MoneyInterface {
    private Money balance;
    private Account owner;
    private Integer number;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
    }
    public Money getBalance() {
        return balance;
    }
    public void setBalance(Money balance) {
        this.balance = balance;
    }
    public Account getOwner() {
        return owner;
    }
    public void setOwner(Account owner) {
        this.owner = owner;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    //проверка доступа к операциям по счету
    public boolean checkBefore(){
        return true;
    }

    public void addMoney(Money money){
        double usdValueIn = money.getValue() *
                money.getCurrency().getUsdCource();
        double usdValueThis = this.balance.getValue() *
                this.balance.getCurrency().getUsdCource();
        //if(usdValueThis < usdValueIn) {
        //    System.out.println("You have no so much!");
        //    return;
        //}
        if(checkBefore()) {
            this.balance.setValue((usdValueThis + usdValueIn) *
                    this.balance.getCurrency().getUsdCource());
        } else {
            System.out.println("No check!");
            return;
        }
    }

    public Money getMoney(double balanceLess){
        //Снятие с любого счета более чем 30 000 за сеанс запрещено
        if(balanceLess > 30000) {
            throw new IllegalArgumentException("Wrong balance less!");
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);
        return this.balance;
    }

    // наследуется без изменений
    public Money getMoneyWithoutLess(){
        return this.balance;
    }

}
