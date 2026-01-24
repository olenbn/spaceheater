package com.my.spaceheater;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpaceHeater {

    public static void main(String[] args) {
        int cores = (Runtime.getRuntime().availableProcessors() / 2)  - 2;
        System.out.println("Starting SpaceHeater on " + cores + " cores.");
        System.out.println("Press Ctrl+C to stop.");

        ExecutorService executor = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            executor.execute(() -> {
                while (true) {
                    // Perform intensive calculation
                    double val = 1000.0;
                    for (int j = 0; j < 1000; j++) {
                        val = Math.pow(val, 1.000001);
                    }
                }
            });
        }
    }
}

