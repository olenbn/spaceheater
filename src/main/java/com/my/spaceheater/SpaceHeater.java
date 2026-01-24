package com.my.spaceheater;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpaceHeater {

    /**
     * The purpose of this program is to make the CPU perform continuous, intensive computations
     * to generate heat, warming up a cold room. The calculation `Math.tan(Math.atan(Math.pow(val, 1.000001)))`
     * is intentionally complex and seemingly redundant to consume CPU cycles.
     *
     * @param args Command line arguments (not used).
     */
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
                        val = Math.tan(Math.atan(Math.pow(val, 1.000001)));
                    }
                }
            });
        }
    }
}

