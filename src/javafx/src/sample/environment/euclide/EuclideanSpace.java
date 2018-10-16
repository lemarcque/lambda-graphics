package sample.environment.euclide;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import sample.environment.base.Dimension;
import sample.environment.base.Environment;
import sample.environment.base.Object;
import sample.environment.base.Space;

public class EuclideanSpace extends Space {


    private Environment environment;        // The graphical environment (framework)
    private Dimension dimension;          // Dimension of the space
    private Straight axisX;                 // The horizontal axe : The abscissa
    private Straight axisY;                 // The vertical axe : The y-axis
    private Group virtualSpace;

    private boolean graduationVisibility;             // visibility of the graduation
    private int scale;

    public EuclideanSpace(Dimension dimension) {
        this.dimension = dimension;
        scale = 10;
    }

    /**
     * Build the space according to his own properties
     */
    public void build(Environment environment) {
        this.environment = environment;
        virtualSpace = new Group();

        this.drawPlan();
        this.drawAxis();
        this.environment.addGroup(virtualSpace);
    }

    /**
     * Draw the plan with a background color
     */
    public void drawPlan() {
        final Rectangle bacgroundRect = new Rectangle(Environment.APP_WIDTH, Environment.APP_HEIGHT);
        virtualSpace.getChildren().add(bacgroundRect);
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
        Group groupAxis = new Group();
        groupAxis.getChildren().add(lineX);
        groupAxis.getChildren().add(lineY);
        virtualSpace.getChildren().add(groupAxis);
    }

    /**
     * Define the visibility of the graduations on axis
     * @param visibility a boolean
     */
    public void setGraduationVisibility(boolean visibility) {
        this.graduationVisibility = visibility;
        virtualSpace.getChildren().get(1).setVisible(visibility);
    }

    /**
     * Adding a point on the euclidean space
     * @param point object
     */
    public void addPoint(Point point) {

        if(point.getName() == null) {
            point.setName("point_" + (pointList.size() + 1));
        }

        pointList.add(point);

        // Creation of a circle
        Circle circle = new Circle(2);

        // calcul of the position
        int originStartX = Environment.APP_WIDTH / 2;
        int originStartY = Environment.APP_HEIGHT / 2;
        int direction = -1;

        circle.setCenterX(originStartX + (point.getPosX() * scale));
        circle.setCenterY(originStartY + (point.getPosY() * scale) * direction);
        circle.setFill(Color.YELLOW);
        virtualSpace.getChildren().add(circle);
    }
}
