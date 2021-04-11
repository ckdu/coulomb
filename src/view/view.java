package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.graph;
import controller.controller;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Chris
 */
public class view {

    public controller myController;

    BorderPane root = new BorderPane();
    Pane graph = new graph();

    GridPane inputs = new GridPane();

    Label q1chargeL = new Label("Q1 Charge (C): ");
    Label q2chargeL = new Label("Q2 Charge (C): ");
    Label q1positionL = new Label("Q1 Position (x, y): ");
    Label q2positionL = new Label("Q2 Position (x, y): ");
    Label distanceL = new Label("Distance (m): ");
    Label forceL = new Label("Electrostatic Force (N): ");
    Label distanceV = new Label();
    Label forceV = new Label();

    TextField q1chargeT = new TextField("0");
    TextField q2chargeT = new TextField("0");
    TextField q1xT = new TextField("0");
    TextField q2xT = new TextField("0");
    TextField q1yT = new TextField("0");
    TextField q2yT = new TextField("0");

    public view() {
        root.setCenter(graph);
        root.setRight(inputs);

        inputs.setVgap(15);
        inputs.setHgap(15);
        inputs.setPadding(new Insets(15, 15, 15, 15));

        inputs.add(q1chargeL, 0, 0);
        inputs.add(q2chargeL, 0, 1);
        inputs.add(q1positionL, 0, 2);
        inputs.add(q2positionL, 0, 3);
        inputs.add(distanceL, 0, 4);
        inputs.add(forceL, 0, 5);

        inputs.add(distanceV, 1, 4);
        inputs.add(forceV, 1, 5);

        inputs.add(q1chargeT, 1, 0);
        inputs.add(q2chargeT, 1, 1);
        inputs.add(q1xT, 1, 2);
        inputs.add(q2xT, 1, 3);
        inputs.add(q1yT, 2, 2);
        inputs.add(q2yT, 2, 3);
    }

    public BorderPane setView() {
        return root;
    }

    public TextField getQ1chargeT() {
        return q1chargeT;
    }

    public TextField getQ2chargeT() {
        return q2chargeT;
    }

    public TextField getQ1xT() {
        return q1xT;
    }

    public TextField getQ2xT() {
        return q2xT;
    }

    public TextField getQ1yT() {
        return q1yT;
    }

    public TextField getQ2yT() {
        return q2yT;
    }

    public Pane getGraph() {
        return graph;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setDistanceV(String distanceV) {
        this.distanceV.setText(distanceV);
    }

    public void setForceV(String forceV) {
        this.forceV.setText(forceV);
    }

}
