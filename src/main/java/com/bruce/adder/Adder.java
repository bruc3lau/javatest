package com.bruce.adder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class Adder {
    private Long nomalLong = 0L;
    private AtomicLong atomicLong = new AtomicLong();
    private LongAdder longAdder = new LongAdder();
    private LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

    private synchronized void syncAdd() {
        this.nomalLong++;
    }

    public static void main(String[] args) throws InterruptedException {
        Adder adder = new Adder();
        int size = 50;
        int batch = 100_0000;
        long start, end;

        CountDownLatch countDownLatch4 = new CountDownLatch(size);
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < batch; x++) {
                    adder.syncAdd();
                }
                countDownLatch4.countDown();
            }, "a").start();
        }
        countDownLatch4.await();
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms " + adder.nomalLong);

        CountDownLatch countDownLatch1 = new CountDownLatch(size);
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < batch; x++) {
                    adder.atomicLong.getAndIncrement();
                }
                countDownLatch1.countDown();
            }, "a").start();
        }
        countDownLatch1.await();
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms " + adder.atomicLong.get());

        CountDownLatch countDownLatch2 = new CountDownLatch(size);
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < batch; x++) {
                    adder.longAdder.increment();
                }
                countDownLatch2.countDown();
            }, "a").start();
        }
        countDownLatch2.await();
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms " + adder.longAdder.sum());

        CountDownLatch countDownLatch3 = new CountDownLatch(size);
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                for (int x = 0; x < batch; x++) {
                    adder.longAccumulator.accumulate(1);
                }
                countDownLatch3.countDown();
            }, "a").start();
        }
        countDownLatch3.await();
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms " + adder.longAccumulator.get());

    }

}
