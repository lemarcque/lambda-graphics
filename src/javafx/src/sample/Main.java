package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author lemarcque
 * Main class of the application
 */

public class Main extends Application {

    // Variable
    private static String APP_NAME = "Lambda";
    private static int APP_WIDTH = 700;
    private static int APP_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creation of the group
        Group root = new Group();

        // Creation and affectation of the Scene
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();

        // adding objects to the root group
        root.getChildren().add(getCircle());
    }

    /**
     * Creation of an circle graphics object
     * @return an Circle object
     */
    private Circle getCircle() {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setCenterX(100);
        circle.setCenterY(200);
        circle.setFill(Color.BEIGE);
        return circle;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
