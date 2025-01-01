package com.example.oppgave1;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author lonnesta
 */
public class LinjePanel extends VBox{
    // Disse to, tf og cp, kan holde info fra bruker, så bør være
    // instansvariable. Lablene trenger ikke.
    TextField tf;
    ColorPicker cp;

    public LinjePanel(String label, int luft){
        super(luft);
        HBox hb = new HBox(luft);
        tf = new TextField();
        tf.setPrefColumnCount(3);
        hb.getChildren().addAll(new Label("Tykkelse :"), tf);
        cp = new ColorPicker();
        getChildren().addAll(new Label(label), hb, cp);
    }
}