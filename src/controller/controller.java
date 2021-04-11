package controller;

import java.text.DecimalFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        myView.getQ1chargeT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
            }
        });

        myView.getQ2chargeT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
            }
        });

        myView.getQ1xT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
            }
        });

        myView.getQ1yT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
            }
        });

        myView.getQ2xT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
            }
        });

        myView.getQ2yT().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                updateGraph();
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

    public void updateGraph() {
        double q1x = Double.parseDouble(myView.getQ1xT().getText());
        double q1y = Double.parseDouble(myView.getQ1yT().getText());
        double q2x = Double.parseDouble(myView.getQ2xT().getText());
        double q2y = Double.parseDouble(myView.getQ2yT().getText());

        double q1charge = Double.parseDouble(myView.getQ1chargeT().getText());
        double q2charge = Double.parseDouble(myView.getQ2chargeT().getText());

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
