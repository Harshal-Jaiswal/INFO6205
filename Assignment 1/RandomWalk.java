/*
 * Copyright (c) 2017. Phasmid Software
 */
package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard
     * moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // TO BE IMPLEMENTED
//        System.out.println("dx: " +dx+", dy: "+dy);
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        // TO BE IMPLEMENTED
        for (int i = 0; i < m; i++) {
            this.randomMove();
        }
    }

    /**
     * Private method to generate a random move according to the rules of the
     * situation. That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the
     * drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // TO BE IMPLEMENTED
//        System.out.println(" x: "+x+" y: "+y);
        return Math.sqrt((x * x) + (y * y));

    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance / n;
    }

    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
        int m = Integer.parseInt(args[0]);
        int n = 100;
        if (args.length > 1) n = Integer.parseInt(args[1]);
//        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
//        for (int n = 0; n < 10; n++) {
            double meanDistance = randomWalkMulti(m, arr[n]);
//            System.out.println(m + "\t" + meanDistance+"\t"+arr[n]);
//        }
        System.out.println(m + " steps: " + meanDistance + " over " + n + " experiments");
    }
}
