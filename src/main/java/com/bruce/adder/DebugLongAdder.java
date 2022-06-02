package com.bruce.adder;

import java.util.concurrent.atomic.LongAdder;

public class DebugLongAdder {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder);
    }
}
