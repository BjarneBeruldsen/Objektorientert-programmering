package com.example.oppgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.io.IOException;

public class TekstSirkel extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //tekst som skal skrives ut
        String tekst = "WELCOME TO JAVA ";

        //Oppretter panel
        Pane panel = new Pane();

        //endrer font
        Font fonten = Font.font("Times New Roman", FontWeight.BOLD, 20);

        //radius til sirkelen
        double radius = 70;

        //x og y til sirkelen
        double senterX = 100.0;
        double senterY = 100.0;

        //endring i grader som skal legges til for hver bokstav
        double vinkel = 90.0;
        double rotasjon = 90.0;
        double leggTilG = 360.0/tekst.length();


        //For løkke som går igjennom tekst og skriver ut
        for(int i=0;i<tekst.length();i++) {
            //finner første tegn i tekst
            char bokstav = tekst.charAt(i);

            //finner x og y ved hjelp av cosinus og sinus
            double x = senterX + radius * Math.sin(Math.toRadians(vinkel));
            double y = senterY + radius * Math.cos(Math.toRadians(vinkel));

            //tegner bokstav
            Text txt = new Text(x, y, ""+bokstav);
            txt.setRotate(rotasjon);
            txt.setFont(fonten);
            //legger til panel
            panel.getChildren().add(txt);

            //legger til grader
            vinkel -= leggTilG;
            rotasjon += leggTilG; //roterer bokstavne
        }

        //Oppretter scene og legger til stage
        Scene scene = new Scene(panel, 250, 250);
        stage.setScene(scene);
        stage.setTitle("Bokstav sirkel");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}