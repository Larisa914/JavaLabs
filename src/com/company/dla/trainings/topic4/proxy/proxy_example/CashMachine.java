package com.company.dla.trainings.topic4.proxy.proxy_example;

public class CashMachine {

    private Account account = AccountImpl.get(1000);

    public void addMoney(int amount) {
        account.add(amount);
    }

    public void withdrawMoney(int amount) {
        account.withdraw(amount);
    }

    public int getMoney() {
        return account.getAmount();
    }

    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine();

        System.out.println(cashMachine.getMoney());
        cashMachine.addMoney(500);
        System.out.println(cashMachine.getMoney());
        cashMachine.withdrawMoney(900);
        System.out.println(cashMachine.getMoney());

    }
}
