package sample.environment;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import sample.environment.euclide.EuclideanSpace;

public class Environment {

    private final Group root;       // The root group
    public static int APP_WIDTH = 700;
    public static int APP_HEIGHT = 500;

    public Environment(Group root) {
        this.root = root;
    }

    public void build() {
        // Creation of a new Euclidean space
        new EuclideanSpace(this);
    }


    public void add(Shape shape) {
        root.getChildren().add(shape);
    }
}
