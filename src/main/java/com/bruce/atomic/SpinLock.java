package com.bruce.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> r = new AtomicReference<Thread>();

    public void lock() {
        System.out.println(Thread.currentThread().getName() + "==come in");
        while (!r.compareAndSet(null, Thread.currentThread())) {
            System.out.println(Thread.currentThread().getName() + "===swap false, will retry lock");
        }
    }

    public void unlock() {
        r.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + "==unlock");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            spinLock.unlock();
        }, "t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(() -> {
            spinLock.lock();
            spinLock.unlock();
        }, "t2").start();
    }
}
