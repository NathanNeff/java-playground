package com.nateneff;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class HashMapTester {

    public static void main(String[] args) {
        // https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
        Map<Integer, AtomicInteger> m = new HashMap<Integer, AtomicInteger>();
        for (int i = 0; i < 5; i++) {
            m.put(i, new AtomicInteger(0));
        }
        for (int i = 0; i <= 5; i++) {
            for (int k = 0; k < 5; k++ ) {
                System.out.printf("Key: %d, Value %d\n", k, m.get(k).incrementAndGet());
            }
        }
    }
}
