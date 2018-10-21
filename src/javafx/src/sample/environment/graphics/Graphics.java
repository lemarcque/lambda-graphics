package sample.environment.graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Graphics {

    public static Circle getCircle() {
        // Creation of a circle
        Circle circle = new Circle(2);
        circle.setFill(Color.YELLOW);
        return circle;
    }
 }
