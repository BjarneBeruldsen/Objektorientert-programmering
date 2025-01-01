package com.example.oppgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class ListingLinje extends Application {
    @Override
    public void start(Stage stage) {
        //Lager scene og legger til stage
        Scene scene = new Scene(new LinePane(), 200, 200);
        stage.setScene(scene);
        stage.setTitle("Skalerbart kryss");
        stage.show();
    }
}

class LinePane extends Pane {
    public LinePane() {
        Line line1 = new Line(10,10,10,10);
        line1.endXProperty().bind(widthProperty().subtract(10));
        line1.endYProperty().bind(heightProperty().subtract(10));
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);

        Line line2 = new Line(10, 10, 10, 10);
        line2.startXProperty().bind(widthProperty().subtract(10));
        line2.endYProperty().bind(heightProperty().subtract(10));
        line2.setStrokeWidth(5);
        line2.setStroke(Color.GREEN);

        getChildren().addAll(line1, line2);
    }
}
