package com.bruce.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> r = new AtomicReference<Thread>();

    public void lock() {
        while (!r.compareAndSet(null, Thread.currentThread())) {
            System.out.println("locking===");
        }
    }

    public void unlock() {
        while (!r.compareAndSet(Thread.currentThread(), null)) {
            System.out.println("unlocking===");
        }
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "lock");
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            spinLock.unlock();
            System.out.println(Thread.currentThread().getName() + "unlock");
        }, "t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "lock");
            spinLock.lock();
            spinLock.unlock();
            System.out.println(Thread.currentThread().getName() + "unlock");
        }, "t2").start();
    }
}
