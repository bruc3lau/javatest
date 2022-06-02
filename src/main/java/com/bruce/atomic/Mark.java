package com.bruce.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class Mark {
    public static void main(String[] args) {
        User user = new User();
        AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<>(100, false);
        boolean compareAndSet = atomicMarkableReference.compareAndSet(100, 101, true, true);
        System.out.println(compareAndSet);
        // update failed
        System.out.println(atomicMarkableReference.getReference());
    }
}
