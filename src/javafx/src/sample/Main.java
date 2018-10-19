package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.environment.geometry.Environment;

import static sample.environment.geometry.Environment.APP_HEIGHT;
import static sample.environment.geometry.Environment.APP_WIDTH;

/**
 * @author lemarcque
 * Main class of the application
 */

public class Main extends Application {

    // Variable
    private static String APP_NAME = "Lambda";


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creation of the group

        // Creation and affectation of the Scene
        Scene scene = new Scene(Environment.getRoot(), APP_WIDTH, APP_HEIGHT);
        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();

        new Environment();
    }

    /**
     * Creation of an circle graphics object
     * @return an JavaFX Circle object
     */
    private Circle getCircle() {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setCenterX(100);
        circle.setCenterY(200);
        circle.setFill(Color.BEIGE);
        return circle;
    }

    /**
     * Create a new rectangle graphics object
     * @return an JavaFX Rectangle object
     */
    private Rectangle getRect() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(Color.BEIGE);
        rectangle.setX(400);
        rectangle.setY(200);
        return rectangle;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
