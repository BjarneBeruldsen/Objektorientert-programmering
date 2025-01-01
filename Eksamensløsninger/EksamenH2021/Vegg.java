package com.example.oppgave1;

import javafx.scene.paint.Color;

public class Vegg extends Element{
    //Instansvariabler som skal være likt for Vegger
    static Color farge = Color.BLACK;
    static double tykkelse = 3;


    public Vegg(double x, double y, Retning r) {
        super(x, y, r);
    }


    @Override
    void oppdater() {
        setStroke(farge);
        setStrokeWidth(3);
    }


    void setFarge(Color f) {
        if(f != null) {
            farge = f;
        }
    }


    void setTykkelse(double t) {
        if (tykkelse > 0) tykkelse = t;
    }
}
