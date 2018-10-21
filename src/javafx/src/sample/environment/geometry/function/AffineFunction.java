package sample.environment.geometry.function;

import sample.environment.base.Function;
import sample.environment.geometry.euclide.Point;

public class AffineFunction extends Function {

    private final double m;         // the slope
    private final double b;         // y-intercept or vertical-intercept

    AffineFunction(double slope, double intercept) {
        m = slope;
        b = intercept;
    }

    /**
     * Create a function according to the coordinate of the point p1 and p3
     * @param p1 The first point
     * @param p2 The second point
     * @return a affine function object
     */
    public static Function create(Point p1, Point p2) {
        float x = 1;                        // by default set to 1
        double m = calculateSlope(p1, p2);
        double b = p1.getPosY() - (m * p1.getPosX());                         // b = y - mx
        return new AffineFunction(m , b);
    }

    /**
     * :: Factory method
     * Create a function named "f", f : x ↦ ax + b
     * according to the indeterminate variable a and b.
     * @param m the slope
     * @param b the y-intercept
     */
    public static Function create(float m, float b) {
        return new AffineFunction(m, b);
    }

    /**
     * the slope of a line is a number that describes both the direction and the steepness of the line.
     * Slope is often denoted by the letter m in a affine function : y = mx + b
     *
     * slope = Δy / Δx
     *
     * @return the slope of the lines of the function
     */
    public static double calculateSlope(Point p1, Point p2) {
        System.out.println();



        return ((double) p2.getPosY() - p1.getPosY()) / (double) (p2.getPosX() - p1.getPosX());
    }

    public double getSlope() {
        return m;
    }


    /* ----- method -----  */

    /**
     * Return the image (x) of the fiber (y) given
     * @param fiber a double value
     * @return a double value
     */
    @Override
    public double getImage(double fiber) {
        return calculate(fiber);
    }

    /**
     * Calculate y according to x
     * @param x a int value
     * @return
     */
    private double calculate(double x) {
        return (m * x)  + b;   // f(x) = mx + b
    }

    @Override
    public String toString() {
        String s = "f(x) = " + m + "x" + " + " + b
                + "\n" + "Slope : " + m
                + "\n" + "Intercept : " + b;
        return s;

    }

}
