package sample.environment.geometry;

import javafx.scene.Group;
import sample.environment.geometry.euclide.CartesianCoordinate;
import sample.environment.geometry.euclide.EuclideanSpace;
import sample.environment.geometry.euclide.Point;


/**
 * Representation physic
 */
public class Environment {

    private static final Group root = new Group();       // The root group
    public static int APP_WIDTH = 700;
    public static int APP_HEIGHT = 500;

    public Environment() {

        // Creation of a euclidean space in 2d
        EuclideanSpace euclideanSpace = new EuclideanSpace(Dimension.TWO);
        euclideanSpace.build(this);
        euclideanSpace.setGraduationVisibility(true);

        // Adding a point
        Point p1 = new Point(15, 45);
        Point p2 = new Point(4, -3);
        Point p3 = new Point(-10, 7);
        Point p4 = new Point(-3, 5);
        Point p5 = new Point(13, 20);

        /*euclideanSpace.addPoint(p1);
        euclideanSpace.addPoint(p2);
        euclideanSpace.addPoint(p3);
        euclideanSpace.addPoint(p4);
        euclideanSpace.addPoint(p5);*/

        // Adding line
        Point p6 = new Point(1, -3);
        Point p7 = new Point(3, 7);
        euclideanSpace.addLine(p6, p7);
    }

    public static Group getRoot() {
        return root;
    }


    /**
     * Add a graphical group the root object
     * @param group
     */
    public void addGroup(Group group) {
        root.getChildren().add(group);
    }
}
