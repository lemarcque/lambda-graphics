package sample.environment.base;

import javafx.scene.Group;
import javafx.scene.Node;
import sample.environment.euclide.EuclideanSpace;
import sample.environment.euclide.Point;

import java.awt.*;

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
        Point p1 = new Point(18, 20);
        Point p2 = new Point(4, -3);
        Point p3 = new Point(-10, 7);
        Point p4 = new Point(-3, 5);
        Point p5 = new Point(13, 20);

        euclideanSpace.addPoint(p1);
        euclideanSpace.addPoint(p2);
        euclideanSpace.addPoint(p3);
        euclideanSpace.addPoint(p4);
        euclideanSpace.addPoint(p5);
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
