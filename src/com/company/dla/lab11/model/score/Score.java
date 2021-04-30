package com.company.dla.lab11.model.score;

import com.company.dla.lab11.Loggable;
import com.company.dla.lab11.model.account.Account;
import com.company.dla.lab11.model.money.Money;
import com.company.dla.lab11.model.money.MoneyInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class Score implements MoneyInterface {
    private Money balance;
    private Account owner;
    private Integer number;

    private Map<String, Integer> methodConstraintMap = new HashMap<>();
    private Map<String, Integer> methodCallMap =new HashMap<>();
    private boolean methodConstraintToggl = true; //???

    private int operLimit;
    private int currentOpers;
    private boolean operLimitToggl = true; //???

    protected Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;

        Class thisClass = this.getClass();
        //System.out.println(thisClass);
        for (Annotation annotation: thisClass.getAnnotations()) {
            if(annotation instanceof OperationLimit){
                this.operLimit = ((OperationLimit)annotation).limit();
                this.operLimitToggl = true;
                //System.out.println(this.operLimit);
            }
        }
        for (Method method: thisClass.getDeclaredMethods()) {
            //System.out.println(method);
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                //System.out.println("DeclaredAnnotations");
                if(annotation instanceof MethodLimit){
                    int limit = ((MethodLimit)annotation).limit();
                    //System.out.println(method.getName());
                    //System.out.println(limit);
                    methodConstraintMap.put(method.getName(), limit);
                    methodCallMap.put(method.getName(), 0);
                    methodConstraintToggl = true;
                }
            }
        }

    }

    public Money getBalance() {
        logIfneeded("getBalance");
        if(!isMethodAvailableByOperLimit("getBalance")){
            System.out.println("Method limit is over!");
            return null;
        }
        return balance;
    }

    public void setBalance(Money balance) {
        logIfneeded("setBalance");
        if(!isMethodAvailableByOperLimit("setBalance")){
            System.out.println("Method limit is over!");
            return; //null
        }
        this.balance = balance;
    }

    public Account getOwner() {
        logIfneeded("getOwner");
        if(!isMethodAvailableByOperLimit("getOwner")){
            System.out.println("Method limit is over!");
            return null;
        }
        return owner;
    }

    public void setOwner(Account owner) {
        logIfneeded("setOwner");
        if(!isMethodAvailableByOperLimit("setOwner")){
            System.out.println("Method limit is over!");
            return;
        }
        this.owner = owner;
    }

    public Integer getNumber() {
        logIfneeded("getNumber");
        if(!isMethodAvailableByOperLimit("getNumber")){
            System.out.println("Method limit is over!");
            return null;
        }
        return number;
    }

    public void setNumber(Integer number) {
        logIfneeded("setNumber");
        if(!isMethodAvailableByOperLimit("setNumber")){
            System.out.println("Method limit is over!");
            return;
        }
        this.number = number;
    }

    //проверка доступа к операциям по счету
    public boolean checkBefore() {
        logIfneeded("checkBefore");
        return true;
    }

    public void addMoney(Money money) {
        logIfneeded("addMoney");
        if(!isMethodAvailableByOperLimit("addMoney")){
            System.out.println("Method limit is over!");
            return;
        }
        if(operLimitToggl && currentOpers >= operLimit){
            System.out.println("Oper limit ends!");
            return;
        }
        currentOpers++;

        double usdValueIn = money.getValue() *
                money.getCurrency().getUsdExchangeRate();
        double usdValueThis = this.balance.getValue() *
                this.balance.getCurrency().getUsdExchangeRate();
        //if(usdValueThis < usdValueIn) {
        //    System.out.println("You have no so much!");
        //    return;
        //}
        if (checkBefore()) {
            this.balance.setValue((usdValueThis + usdValueIn) *
                    this.balance.getCurrency().getUsdExchangeRate());
        } else {
            System.out.println("No check!");
        }
    }

    public Money getMoney(double balanceLess) {
        logIfneeded("getMoney");
        if(!isMethodAvailableByOperLimit("getMoney")){
            System.out.println("Method limit is over!");
            return null;
        }
        if(operLimitToggl && currentOpers >= operLimit){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;

        //Снятие с любого счета более чем 30 000 за сеанс запрещено
        if (balanceLess > 30000) {
            throw new IllegalArgumentException("Wrong balance less!");
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);
        return this.balance;
    }

    // наследуется без изменений
    public Money getMoneyWithoutLess() {
        logIfneeded("getMoneyWithoutLess");
        if(!isMethodAvailableByOperLimit("getMoneyWithoutLess")){
            System.out.println("Method limit is over!");
            return null;
        }
        if(operLimitToggl && currentOpers >= operLimit){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;

        return this.balance;
    }

    protected void logIfneeded(String methodName){
        Class thisClass = this.getClass();
        for (Annotation annotation:
                thisClass.getAnnotations()) {
            if(annotation instanceof Loggable){
                System.out.println("We call method " + methodName);
            }
        }
    }

    protected boolean isMethodAvailableByOperLimit(String methodName){
        if(methodConstraintMap.containsKey(methodName)){
            int currentCalls = methodCallMap.get(methodName);
            int limitCalls = methodConstraintMap.get(methodName);
            System.out.println("------- " + methodName);
            System.out.println(currentCalls);
            System.out.println(limitCalls);
            if(currentCalls >= limitCalls){
                return false;
            }
            currentCalls++;
            methodCallMap.put(methodName, currentCalls);
        }
        return true;
    }

}
