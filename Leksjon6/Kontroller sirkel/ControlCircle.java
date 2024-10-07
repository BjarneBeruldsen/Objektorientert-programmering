/*
 * Denne klassen representerer en JavaFX-applikasjon som lar brukeren justere størrelsen 
 * og posisjonen til en sirkel på skjermen. Applikasjonen inneholder knapper for å 
 * forstørre, minske og flytte sirkelen til venstre eller høyre. Sirkelen vises i et 
 * CirclePane, som er plassert midt i vinduet, mens kontrollene er plassert nederst.
 */


package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import java.io.IOException;

public class ControlCircle extends Application {
    //Oppretter circlePane objekt slik at den eksisterer i hele applikasjonen
    private CirclePane circlePane = new CirclePane();
    //oppretter knapper slik at de kan gjennbrukes i andre klasser/metoder
    private Button btForstørr;
    private Button btMinsk;
    //knapper for å flytte sirkel
    private Button btVenstre;
    private Button btHøyre;

    @Override
    public void start(Stage stage) throws IOException {
        //Oppretter panel
        HBox panel = new HBox();
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        //Oppretter knapp for forstørring
        btForstørr = new Button("Forstørr");
        //knapp for minsking
        btMinsk = new Button("Minsk");

        //knapper for å flytte til venstre og høyre
        btVenstre = new Button("Venstre");
        btHøyre = new Button("Høyre");

        panel.getChildren().addAll(btForstørr, btMinsk,
                                   btVenstre, btHøyre);
        //kaller på lytterklasse ved trykk på knapper
        btForstørr.setOnAction(e -> {
            circlePane.enlarge();
        });

        btMinsk.setOnAction(e -> {
            circlePane.shrink();
        });

        //flytter til venstre og høyre
        btVenstre.setOnAction(e -> {
            circlePane.flttVenstre();
        });

        btHøyre.setOnAction(e -> {
            circlePane.flyttHøyre();
        });

        //lager panel for å plassering
        BorderPane borderPane = new BorderPane();
        //legger sirkel i midten
        borderPane.setCenter(circlePane);
        //setter knapp nederst
        borderPane.setBottom(panel);
        BorderPane.setAlignment(panel, Pos.CENTER);

        //lager scene og legger til stage
        Scene scene = new Scene(borderPane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Juster størrelse");
        stage.show();


    }


    //Oppretter circlepane klassen
    class CirclePane extends Pane {
        //oppretter circle objekt
        private Circle sirkel = new Circle(50);

        //sirkel panel
        public CirclePane(){
            getChildren().add(sirkel);
            //svart ukant
            sirkel.setStroke(Color.BLACK);
            sirkel.setFill(Color.WHITE);
            sirkel.setCenterX(100);
            sirkel.setCenterY(100);
        }

        //metode som forstørrer sirkel
        public void enlarge() {
            sirkel.setRadius(sirkel.getRadius() + 2);
        }

        //metode som minsker sirkel
        public void shrink() {
            if(sirkel.getRadius() > 2) {
                sirkel.setRadius(sirkel.getRadius()-2);
            }
            else {
                sirkel.setRadius(sirkel.getRadius());
            }
        }

        //metode for å flytte til høyre
        public void flyttHøyre() {
            sirkel.setCenterX(sirkel.getCenterX()+10);
        }
        //metode for å flytte til venstre
        public void flttVenstre() {
            sirkel.setCenterX(sirkel.getCenterX()-10);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}