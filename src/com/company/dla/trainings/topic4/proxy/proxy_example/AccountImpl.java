package com.company.dla.trainings.topic4.proxy.proxy_example;

//@Loggable(prefix = "my prefix")
//@Loggable(suffix = ">", prefix = "<")
@Loggable
@PerformanceLog
public class AccountImpl implements Account {
    private int amount;

    private AccountImpl(int amount) {
        this.amount = amount;
    }

    @Override
    public void withdraw(int amount) {
        System.out.printf("withdraw %d roubles%n", amount);
        this.amount -= amount;
    }

    @Override
    public void add(int amount) {
        System.out.printf("add %d roubles%n", amount);
        this.amount += amount;
    }

    @NotLoggable
    @Override
    public int getAmount() {
        return amount;
    }

    public static Account get(int amount) {
        Account account = new AccountImpl(amount);
        Account result = account;

        if (account.getClass().getAnnotation(Loggable.class) != null) {
            result = Proxies.getLoggableProxy(result);
        }

        if (account.getClass().getAnnotation(PerformanceLog.class) != null) {
            result = Proxies.getPerformanceLogProxy(result);
        }

        return result;
    }
}
