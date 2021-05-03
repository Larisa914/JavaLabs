package com.company.dla.trainings.topic4.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Logger;

public class DynamicInvocationHandler implements InvocationHandler {

    //    Swimmer swimmer = swimType -> System.out.println("SWIM!!!");
    private Swimmer swimmer;

//    private static Logger LOGGER = Logger.getLogger(
//            DynamicInvocationHandler.class.getName());


    public DynamicInvocationHandler(Swimmer swimmer) {
        this.swimmer = swimmer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
//        method.invoke(proxy, args);
        Object result = null;
        System.out.println(String.format("Invoked method: {%s}", method.getName()));
        if ("swim".equals(method.getName())) {
//            System.out.println(String.format("Really need to swim now with param value \"%s\"!!!", args[0]))

//               WRONG!!!!
//            ((Swimmer)proxy).swim((String) args[0]);
            result = execWithBenchmark(method, args);
        } else if ("superSwim".equals(method.getName())) {
            System.out.println("SUPER START!");
            System.out.print("    ");
            result = execWithBenchmark(method, args);
            System.out.println("SUPER FINISH!");
        } else if (method.getDeclaringClass() == Map.class) {
            System.out.println("map method");
        }
        System.out.println("Invocation end");
//        method.invoke(proxy, args);
        return result;
    }

    private Object execWithBenchmark(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object result;
        long start = System.currentTimeMillis();
        result = method.invoke(swimmer, args);
        long end = System.currentTimeMillis();
        System.out.printf("    Exec time: %d%n", end - start);
        return result;
    }
}
