package main;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;
import view.*;
import controller.*;


/**
 *
 * @author Chris
 */
public class CoulombsLaw extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        view myView = new view();
        model myModel = new model();
        controller myController = new controller(myModel, myView);
        VBox root = new VBox();

        root.getChildren().add(myController.setView());

        Scene scene = new Scene(root, 1920 / 2, 1080 / 2);

        scene.getStylesheets().add("/view/stylesheet.css");

        stage.setTitle("Coulomb's Law Simulation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
