package sample.environment;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import sample.environment.base.Object;
import sample.environment.base.Space;

public class SpaceImpl implements Space {

    private Environment environment;        // The graphical environment (framework)
    protected Dimension dimension;          // Dimension of the space
    private Straight axisX;                 // The horizontal axe : The abscissa
    private Straight axisY;                 // The vertical axe : The y-axis

    public SpaceImpl(Environment environment) {
        this.environment = environment;
        this.build();
    }

    public void build() {
        this.drawPlan();
        this.drawAxis();
    }

    /**
     * Draw the plan with a background color
     */
    public void drawPlan() {
        final Rectangle bacgroundRect = new Rectangle(Environment.APP_WIDTH, Environment.APP_HEIGHT);
        environment.add(bacgroundRect);
    }

    /**
     * Draw axis with color and graduation settled
     */
    public void drawAxis() {
        // X-Axis
        final Line lineX = new Line();
        lineX.setStartX(0);
        lineX.setEndX(Environment.APP_WIDTH);
        lineX.setStartY(Environment.APP_HEIGHT / 2);
        lineX.setEndY(Environment.APP_HEIGHT / 2);
        lineX.setStroke(Color.WHITE);

        // Y-Axis
        final Line lineY = new Line();
        lineY.setStartX(Environment.APP_WIDTH / 2);
        lineY.setEndX(Environment.APP_WIDTH / 2);
        lineY.setStartY(0);
        lineY.setEndY(Environment.APP_HEIGHT);
        lineY.setStroke(Color.WHITE);

        // Adding to the group root
        environment.add(lineX);
        environment.add(lineY);
    }

    /**
     * Draw an geometric object from the Object
     * @param object
     */
    public void add(Object object) {
        System.out.print("Draw new object");
    }
}
