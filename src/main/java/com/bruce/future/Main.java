package com.bruce.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> ft = new FutureTask<String>(() -> {
            return "good";
        });
        ft.run();
        System.out.println(ft.get());
    }
}