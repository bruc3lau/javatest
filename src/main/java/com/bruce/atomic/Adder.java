package com.bruce.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;

@Getter
public class Adder {
    private AtomicInteger num = new AtomicInteger(0);

    private void increase() {
        num.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Adder adder = new Adder();
        int size = 50;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    for (int x = 0; x < 1000; x++) {
                        adder.increase();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        // try {
        countDownLatch.await();
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // try {
        // TimeUnit.SECONDS.sleep(1);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println(adder.getNum());
    }

}
