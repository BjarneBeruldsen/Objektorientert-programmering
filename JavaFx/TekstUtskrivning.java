/* Oppgave 14.4 Skriv et program som viser teksten JavaFx
 * i fem utgaver, vertikalt i ulike farger.
 * Alle med Times New Roman, feit, kursiv, 24 pt
 */

package com.example.oppgave3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.io.IOException;

public class TekstUtskrivning extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Oppretter vertikalt panel
        VBox panel = new VBox(15);
        panel.setAlignment(Pos.CENTER);

        //Oppretter text element
        Text t1 = new Text(0, 0, "JavaFx");
        Font fonten = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24);

        t1.setFont(fonten);
        t1.setFill(Color.RED);

        //text element 2
        Text t2 = new Text(0, 0, "JavaFx");
        t2.setFont(fonten);
        t2.setFill(Color.BLUE);

        Text t3 = new Text(0, 0, "JavaFx");
        t3.setFont(fonten);
        t3.setFill(Color.GREEN);

        //legger elementer til panel
        panel.getChildren().add(t1);
        panel.getChildren().add(t2);
        panel.getChildren().add(t3);

        //oppretter scene og legger til stage
        Scene scene = new Scene(panel);
        stage.setTitle("Tekst i ulik farge");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}