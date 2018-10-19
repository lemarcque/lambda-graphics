package sample.environment.geometry;

import sample.environment.geometry.euclide.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Space {

    protected List<Point> pointList;

    public Space() {
        pointList = new ArrayList<>();
    }

    /**
     * Build the space
     */
    public abstract void build(Environment environment);

    /**
     * Draw the plan with a background color
     */
    protected abstract void drawPlan();


    /**
     * Draw axis with color and graduation settled
     */
    protected abstract void drawAxis();

}
