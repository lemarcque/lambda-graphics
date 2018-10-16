package sample.environment.euclide;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import sample.environment.base.Dimension;
import sample.environment.base.Environment;
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
        scale = 50;
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

        Group groupAxis = new Group();

        // Position of axis
        int startYOfXAxis = Environment.APP_HEIGHT / 2;
        int startXOfYAxis = Environment.APP_WIDTH / 2;

        // X-Axis
        final Line lineX = new Line();
        lineX.setStartX(0);
        lineX.setEndX(Environment.APP_WIDTH);
        lineX.setStartY(startYOfXAxis);
        lineX.setEndY(startYOfXAxis);
        lineX.setStroke(Color.WHITE);

        // Y-Axis
        final Line lineY = new Line();
        lineY.setStartX(startXOfYAxis);
        lineY.setEndX(startXOfYAxis);
        lineY.setStartY(0);
        lineY.setEndY(Environment.APP_HEIGHT);
        lineY.setStroke(Color.WHITE);

        int graduationSize = 10;

        // graduation for X-AXis
        for(int i = 1; i < (Environment.APP_WIDTH / scale) + 1; i++) {
            int startXGraduation = i * scale;
            int startYGraduation = startYOfXAxis - (graduationSize /2);
            Line l = new Line(startXGraduation, startYGraduation, startXGraduation,startYGraduation + graduationSize);
            l.setStroke(Color.WHITE);
            groupAxis.getChildren().add(l);
        }

        // graduation for Y-AXis
        for(int i = 1; i < (Environment.APP_HEIGHT / scale) + 1; i++) {
            int startXGraduation = startXOfYAxis - (graduationSize / 2);
            int startYGraduation = i * scale;
            Line l = new Line(startXGraduation, startYGraduation, startXGraduation + graduationSize, startYGraduation);
            l.setStroke(Color.WHITE);
            groupAxis.getChildren().add(l);
        }

        // Adding to the group root
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



        // calcul of the position
        int originStartX = Environment.APP_WIDTH / 2;
        int originStartY = Environment.APP_HEIGHT / 2;
        int direction = -1;

        // Creation of a circle
        Circle circle = new Circle(2);
        circle.setCenterX(originStartX + (point.getPosX() * scale));
        circle.setCenterY(originStartY + (point.getPosY() * scale) * direction);
        circle.setFill(Color.YELLOW);
        virtualSpace.getChildren().add(circle);
    }
}
