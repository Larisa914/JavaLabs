package com.company.dla.trainings.topic3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            integerList.add(i);
        }

        Set<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            integerHashSet.add(i);
        }

        Set<Integer> integerTreeSet = new TreeSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            integerTreeSet.add(i);
        }

        Random random = new Random();
        int randomInt = 0;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            randomInt = random.nextInt();
            System.out.println(integerList.contains(randomInt));
        }
        long listDuration = System.currentTimeMillis() - startTime;

        long maxHashSetTime = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long startOperTime = System.currentTimeMillis();
            randomInt = random.nextInt();
            System.out.println(integerHashSet.contains(randomInt));
            long totalOperTime = System.currentTimeMillis() - startOperTime;
            maxHashSetTime = maxHashSetTime < totalOperTime
                    ? totalOperTime : maxHashSetTime;
        }
        long setDuration = System.currentTimeMillis() - startTime;

        long maxTreeSetTime = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long startOperTime = System.currentTimeMillis();
            randomInt = random.nextInt();
            System.out.println(integerTreeSet.contains(randomInt));
            long totalOperTime = System.currentTimeMillis() - startOperTime;
            maxTreeSetTime = maxTreeSetTime < totalOperTime
                    ? totalOperTime : maxTreeSetTime;
        }
        long treeDuration = System.currentTimeMillis() - startTime;

        System.out.println("list duration " + listDuration);
        System.out.println("hashset duration " + setDuration);
        System.out.println("hashset maxTime " + maxHashSetTime);
        System.out.println("treeset duration " + treeDuration);
        System.out.println("treeset maxTime " + maxTreeSetTime);
    }
}
