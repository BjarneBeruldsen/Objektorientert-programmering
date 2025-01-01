package com.example.oppgave1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lonnesta
 */
public class Husdesign extends Application {

    BorderPane mPane;
    Pane sPane;
    RadioButton veggButton, dørButton, vinduButton, velgButton;
    VBox elementVBox, retningVBox;
    ToggleGroup elementGroup;
    ToggleGroup retningGroup;
    final static int LUFT = 10;
    static String retningValg;
    static String elementValg;
    LinjePanel veggLP, dørLP, vinduLP;


    @Override
    public void start(Stage primaryStage) {
        BorderPane root = hovedPane();
        Scene scene = new Scene(root, 800, 500);

        primaryStage.setTitle("Husdesign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BorderPane hovedPane(){
        mPane = new BorderPane();
        mPane.setLeft(venstrePane());
        mPane.setRight(høyrePane());
        mPane.setCenter(new SenterPanel());
        return mPane;
    }

    private Pane venstrePane(){
        VBox venstreBox = new VBox(LUFT);
        venstreBox.getChildren().addAll(velgPane(), retningPane());
        pynt(venstreBox);
        return venstreBox;
    }

    private Pane velgPane(){
        elementVBox = new VBox(LUFT);
        veggButton = new RadioButton("VEGG");
        dørButton = new RadioButton("DØR");
        vinduButton = new RadioButton("VINDU");
        velgButton = new RadioButton("VELG");
        elementGroup = new ToggleGroup();
        veggButton.setToggleGroup(elementGroup);
        dørButton.setToggleGroup(elementGroup);
        vinduButton.setToggleGroup(elementGroup);
        velgButton.setToggleGroup(elementGroup);
        elementVBox.getChildren().addAll(veggButton, dørButton, vinduButton, velgButton);
        pynt(elementVBox);
        veggButton.setOnAction(e -> valg());
        dørButton.setOnAction(e -> valg());
        vinduButton.setOnAction(e -> valg());
        velgButton.setOnAction(e -> valg());

        return elementVBox;
    }

    protected void valg(){
        if (veggButton.isSelected()) elementValg = veggButton.getText();
        if (dørButton.isSelected()) elementValg = dørButton.getText();
        if (vinduButton.isSelected()) elementValg = vinduButton.getText();
        if (velgButton.isSelected()) elementValg = velgButton.getText();
        Toggle t = retningGroup.getSelectedToggle();
        if (t != null) retningValg = ((RadioButton)t).getText();
    }
    private Pane retningPane(){
        retningVBox = new VBox(LUFT);
        retningGroup = new ToggleGroup();
        for (Retning r : Retning.values()) {
            RadioButton rb = new RadioButton(r.toString());
            rb.setToggleGroup(retningGroup);
            retningVBox.getChildren().add(rb);
            rb.setOnAction(e -> valg());
        }
        //retningGroup.getSelectedToggle().toString()
        pynt(retningVBox);
        return retningVBox;
    }

    private Pane høyrePane(){
        VBox vb = new VBox(LUFT);
        veggLP = new LinjePanel("VEGG", LUFT);
        pynt(veggLP);
        dørLP = new LinjePanel("DØR", LUFT);
        pynt(dørLP);
        vinduLP = new LinjePanel("VINDU", LUFT);
        pynt(vinduLP);
        vb.getChildren().addAll(veggLP, dørLP, vinduLP);
        pynt(vb);
        return vb;
    }


    private void pynt(Pane p){
        p.setStyle("-fx-background-color: LIGHTGREY; "
                + "-fx-border-width: 2px;"
                + "-fx-border-color: green");
        p.setPadding(new Insets(10));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
