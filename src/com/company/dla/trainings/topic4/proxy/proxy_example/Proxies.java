package com.company.dla.trainings.topic4.proxy.proxy_example;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Proxies {
    private static final Logger LOGGER = Logger.getLogger("");
    static {
        try {
            LOGGER.addHandler(new FileHandler("a.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Proxies() {
    }

    public static Account getLoggableProxy(Account account) {
        return (Account) Proxy.newProxyInstance(
                account.getClass().getClassLoader(),
                new Class[] {Account.class},
                new LoggableInvocationHandler(account));
    }

    public static Account getPerformanceLogProxy(Account account) {
        return (Account) Proxy.newProxyInstance(
                account.getClass().getClassLoader(),
                new Class[] {Account.class},
                new PerformanceLogInvocationHandler(account));
    }

    private static class LoggableInvocationHandler implements InvocationHandler {
        private Account account;
        public LoggableInvocationHandler(Account account) {
            this.account = account;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getAnnotation(NotLoggable.class) == null) {
                LOGGER.info("Method invoked : " + method.getName());
            }

            return method.invoke(account, args);
        }
    }

    private static class PerformanceLogInvocationHandler implements InvocationHandler {
        private Account account;
        public PerformanceLogInvocationHandler(Account account) {
            this.account = account;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(account, args);
            long end = System.currentTimeMillis();
            if (method.getAnnotation(NotLoggable.class) == null) {
                LOGGER.info(String.format("PERFORMANCE LOG. Method : %s executed in %d milliseconds %n", method.getName(), end - start));
            }
            return result;
        }
    }
}
