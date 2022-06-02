package com.bruce.threadlocal;

import java.util.concurrent.CountDownLatch;

class MyThreadLocal extends ThreadLocal {

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int n = i;
            new Thread(() -> {
                threadLocal.set(n + "");
                countDownLatch.countDown();
            }, i + "").start();
        }
        countDownLatch.await();
        System.out.println(threadLocal);
    }
}
