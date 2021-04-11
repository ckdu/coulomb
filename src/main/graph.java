/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Chris
 */
public class graph extends Pane {

    private BorderPane graphRoot = new BorderPane();
    private Pane graphPane = new Pane();

    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> chart = new LineChart(xAxis, yAxis);

    private XYChart.Series<Number, Number> q1 = new XYChart.Series<>();
    private XYChart.Series<Number, Number> q2 = new XYChart.Series<>();

    public graph() {
        Data<Number, Number> q1v = new Data<Number, Number>(0, 0);
        Data<Number, Number> q2v = new Data<Number, Number>(0, 0);

        xAxis.setLabel("x (m)");
        yAxis.setLabel("y (m)");
        xAxis.setAutoRanging(true);
        yAxis.setAutoRanging(true);

        q1.setName("Q1");
        q2.setName("Q2");

        chart.setAnimated(false);
        chart.getData().addAll(q1, q2);

        q1.getData().add(q1v);
        q2.getData().add(q2v);

        this.getChildren().add(chart);
    }

    public graph(double q1x, double q1y, double q2x, double q2y) {
        Data<Number, Number> q1v = new Data<Number, Number>(q1x, q1y);
        Data<Number, Number> q2v = new Data<Number, Number>(q2x, q2y);

        xAxis.setLabel("x (m)");
        yAxis.setLabel("y (m)");
        xAxis.setAutoRanging(true);
        yAxis.setAutoRanging(true);

        q1.setName("Q1");
        q2.setName("Q2");

        chart.setAnimated(false);
        chart.getData().addAll(q1, q2);

        q1.getData().add(q1v);
        q2.getData().add(q2v);

        this.getChildren().add(chart);
    }

    public BorderPane createGraph() {
        return graphRoot;
    }
}
