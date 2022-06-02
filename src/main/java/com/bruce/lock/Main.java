package com.bruce.lock;

import java.util.concurrent.locks.ReentrantLock;

class Main {
    // Object o = new Object();

    public static void main(String[] args) {
        Object o = new Object();
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            lock.lock();
            System.out.println(666);
            lock.unlock();
            // lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            System.out.println(555);
            lock.unlock();
        }).start();
    }
}
