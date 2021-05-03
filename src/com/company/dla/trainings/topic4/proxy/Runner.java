package com.company.dla.trainings.topic4.proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Swimmer swimmerProxy = (Swimmer) Proxy.newProxyInstance(
                Swimmer.class.getClassLoader(),
                new Class[]{Swimmer.class},
                new DynamicInvocationHandler(new RealSwimmer()));

        Swimmer swimmerProxy2 = (Swimmer) Proxy.newProxyInstance(
                Swimmer.class.getClassLoader(),
                new Class[]{Swimmer.class},
                new DynamicInvocationHandler(swimmerProxy));

        doSomeSwim(new RealSwimmer());
        System.out.println("---------");
        doSomeSwim(swimmerProxy2);


        Jumper proxyInstance = (Jumper) Proxy.newProxyInstance(
                Runner.class.getClassLoader(),
                new Class[]{Jumper.class, Swimmer.class, Map.class},
                new DynamicInvocationHandler(new RealSwimmer()));

        System.out.println("-------------------");
        proxyInstance.jump();
        Swimmer swimmer = (Swimmer) proxyInstance;
        doSomeSwim(swimmer);

        Map map = (Map) proxyInstance;
        map.values();

    }

    static void doSomeSwim(Swimmer swimmer) {
        swimmer.swim("Jump");
        swimmer.superSwim();
    }

}