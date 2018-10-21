package sample.environment.geometry.euclide;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import sample.environment.base.Function;
import sample.environment.base.IntegerOperation;
import sample.environment.geometry.Dimension;
import sample.environment.geometry.Environment;
import sample.environment.geometry.Space;
import sample.environment.geometry.function.AffineFunction;
import sample.environment.graphics.Graphics;

public class EuclideanSpace extends Space {


    private Environment environment;        // The graphical environment (framework)
    private Dimension dimension;          // Dimension of the space
    private AxisLine axisX;                 // The horizontal axe : The abscissa
    private AxisLine axisY;                 // The vertical axe : The y-axis
    private Group virtualSpace;

    private boolean graduationVisibility;             // visibility of the graduation
    private int scale;

    // calcul of the position origin
    final int originStartX = Environment.APP_WIDTH / 2;
    final int originStartY = Environment.APP_HEIGHT / 2;

    public EuclideanSpace(Dimension dimension) {
        this.dimension = dimension;
        scale = 1;
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

        axisX = new AxisLine();
        axisY = new AxisLine();


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
        /*axisX.setGraduationCount(Environment.APP_HEIGHT / scale);
        for(int i = 1; i < axisX.getGraduationCount() + 1; i++) {
            int startXGraduation = i * scale;
            int startYGraduation = startYOfXAxis - (graduationSize /2);
            Line l = new Line(startXGraduation, startYGraduation, startXGraduation,startYGraduation + graduationSize);
            l.setStroke(Color.WHITE);
            groupAxis.getChildren().add(l);
        }

        // graduation for Y-AXis
        axisY.setGraduationCount(Environment.APP_HEIGHT / scale);
        for(int i = 1; i < axisY.getGraduationCount() + 1; i++) {
            int startXGraduation = startXOfYAxis - (graduationSize / 2);
            int startYGraduation = i * scale;
            Line l = new Line(startXGraduation, startYGraduation, startXGraduation + graduationSize, startYGraduation);
            l.setStroke(Color.WHITE);
            groupAxis.getChildren().add(l);
        }*/

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

        int direction = -1;


        // get circle
        Circle circle = Graphics.getCircle();
        circle.setCenterX(originStartX + (point.getPosX() * scale));
        circle.setCenterY(originStartY + (point.getPosY() * scale) * direction);
        virtualSpace.getChildren().add(circle);
    }

    /**
     * Draw a new line on the space
     * - get the function of the representative lines according the coordinates c1 and c2
     * - draw the lines by adding a set of points that will make the line
     * @param p1 The first point with their coordinate of the first point
     * @param p2 The second point coordinate of the second point
     */
    public void addLine(Point p1, Point p2) {

            // The point of the segment
            //this.addPoint(p1);
            //this.addPoint(p2);

            boolean isAffiLine = false;

            // Draw the point that compose the segment
            int direction = -1;
            int deltaY = Math.abs(p1.getPosY() - p2.getPosY());
            double slope = -1;
            double posX = 0;     // position x of the circle displayed
            double posY = 0;     // position y of the circle displayed
            int j = 0;           // counter for the loop that will draw the point that compose the line

            // determine if it is a line
            if(!(p1.getPosX() == p2.getPosX())) {

                // calculate the function of the line
                isAffiLine = true;
                Function f = AffineFunction.create(p1, p2);
                slope = ((AffineFunction) f).getSlope();
            }



            double p1x = originStartX + (p1.getPosX() * scale);
            double p1y = originStartY + (p1.getPosY() * scale) * direction;
            double p2x = originStartX + (p2.getPosX() * scale);
            double p2y = originStartY + (p2.getPosY() * scale) * direction;

            if(!(p2.getPosX() > p1.getPosX())) {
                p2x = originStartX + (p1.getPosX() * scale);
                p2y = originStartY + (p1.getPosY() * scale) * direction;
                p1x = originStartX + (p2.getPosX() * scale);
                p1y = originStartY + (p2.getPosY() * scale) * direction;
            }


            while(!(posX == p2x && posY == p2y)) {

                posX = p1x;
                posY = p1y + ((slope * j) * direction);

                if(isAffiLine)
                    posX += j;

                Circle circleOfLine = Graphics.getCircle();
                circleOfLine.setRadius(.75);
                circleOfLine.setFill(Color.WHITE);
                circleOfLine.setCenterX(posX);
                circleOfLine.setCenterY(posY);

                // adding circle to the space scene
                virtualSpace.getChildren().add(circleOfLine);
                j++;
            }
    }

}
