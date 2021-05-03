package com.company.dla.trainings.topic3.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashResize {
    public static void main(String[] args) {
        Map<Integer, String> map =  IntStream.rangeClosed(1, 1_000_000)
                .mapToObj(Integer::new)
                .collect(Collectors.toMap(i -> i, String::valueOf));

        HashMap<Integer, String> hmap = new HashMap<>(map);
        hmap.clear();
        hmap.put(1, "1");
        System.out.println(hmap);
    }
}
