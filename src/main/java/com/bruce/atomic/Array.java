package com.bruce.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Array {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println(atomicIntegerArray);
    }
}
