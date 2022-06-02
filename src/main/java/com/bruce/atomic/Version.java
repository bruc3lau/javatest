package com.bruce.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Version {
    public static void main(String[] args) {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        AtomicStampedReference<User> r = new AtomicStampedReference<User>(user, 1);
        boolean compareAndSet = r.compareAndSet(user, user, 1, 10);
        boolean compareAndSet2 = r.compareAndSet(user, user, 10, 10);
        System.out.println(compareAndSet);
        System.out.println(compareAndSet2);
        System.out.println(r.getStamp());
    }
}
