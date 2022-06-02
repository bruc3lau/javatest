package com.bruce.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    // private static final Unsafe

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        boolean compareAndSet = i.compareAndSet(0, 2022);
        System.out.println(compareAndSet + "" + i);
        boolean compareAndSet2 = i.compareAndSet(1, 2023);
        System.out.println(compareAndSet2 + "" + i);
        // unsafe
        // Unsafe
        i.getAndIncrement();

        AtomicReference<User> atomicReference = new AtomicReference<User>();
        User user = new User();
        user.setId(0);
        User user2 = new User();
        user2.setId(1);
        boolean compareAndSet3 = atomicReference.compareAndSet(null, user);
        System.out.println(compareAndSet3 + " " + atomicReference);
        boolean compareAndSet4 = atomicReference.compareAndSet(null, user2);
        System.out.println(compareAndSet4 + " " + atomicReference);
    }
}

class User {
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.valueOf(id);
    }
}
