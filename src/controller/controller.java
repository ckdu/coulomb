package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.graph;
import model.*;
import view.*;

/**
 *
 * @author Chris
 */
public class controller {

    public view myView;
    public model myModel;

    private double q1;
    private double q2;
    private double q1x;
    private double q1y;
    private double q2x;
    private double q2y;

    public controller(model m, view v) {
        myModel = m;
        myView = v;

        ArrayList<TextField> textfields = new ArrayList<>();
        textfields.add(myView.getQ1chargeT());
        textfields.add(myView.getQ2chargeT());
        textfields.add(myView.getQ1xT());
        textfields.add(myView.getQ1yT());
        textfields.add(myView.getQ2xT());
        textfields.add(myView.getQ2yT());

        for (TextField t : textfields) {
            t.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String o, String n) {
                    if (!n.matches("-?\\d{0,7}([\\.]\\d{0,2})?") &&  -Math.pow(10, 10) <= toDouble(n) && toDouble(n) <= Math.pow(10, 10)) {
                        t.setText(o);
                    }
                    updateGraph();
                }
            });
        }

        myView.getResetB().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                for (TextField t : textfields) {
                    t.setText("0");
                    updateGraph();
                }
            }
        });
    }

    public String round(double number) {
        if (number < 100000) {
            DecimalFormat df = new DecimalFormat("###.##");
            return df.format(number);
        } else {
            DecimalFormat df = new DecimalFormat("0.0E0");
            return df.format(number);
        }
    }

    public double toDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public void updateGraph() {
        double q1x = toDouble(myView.getQ1xT().getText());
        double q1y = toDouble(myView.getQ1yT().getText());
        double q2x = toDouble(myView.getQ2xT().getText());
        double q2y = toDouble(myView.getQ2yT().getText());

        double q1charge = toDouble(myView.getQ1chargeT().getText());
        double q2charge = toDouble(myView.getQ2chargeT().getText());

        double distance = Math.sqrt((q2x - q1x) * (q2x - q1x) + (q2y - q1y) * (q2y - q1y));
        double k = 8.987551787 * Math.pow(10, 9);
        double force = k * (Math.abs(q1charge * q2charge)) / (Math.pow(distance, 2));

        myView.getRoot().setCenter(new graph(q1x, q1y, q2x, q2y));

        myView.setDistanceV(round(distance));

        myView.setForceV(round(force));
    }

    public BorderPane setView() {
        return myView.setView();
    }

}
