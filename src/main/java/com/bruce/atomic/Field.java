package com.bruce.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Field {
    private volatile int num = 0;
    private AtomicIntegerFieldUpdater<Field> newUpdater = AtomicIntegerFieldUpdater.newUpdater(Field.class, "num");

    private AtomicInteger count = new AtomicInteger(0);

    public void increase(Field field) {
        newUpdater.getAndIncrement(field);
    }

    public static void main(String[] args) throws InterruptedException {
        Field field = new Field();
        int size = 50;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < 10000; x++) {
                    field.increase(field);
                }
                countDownLatch.countDown();
            }, "a").start();
        }
        countDownLatch.await(3, TimeUnit.SECONDS);
        long stop1 = System.currentTimeMillis();
        System.out.println(field.num);
        System.out.println(stop1 - start1 + "ms");

        CountDownLatch countDownLatch2 = new CountDownLatch(size);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < 10000; x++) {
                    field.count.getAndIncrement();
                }
                countDownLatch2.countDown();
            }, "a").start();
        }
        countDownLatch2.await();
        long stop2 = System.currentTimeMillis();
        System.out.println(field.count);
        System.out.println(stop2 - start2 + "ms");
    }
}
