package com.example.oppgave1;

import javafx.scene.paint.Color;

public class Dør extends Element{
    //Instansvariabler som skal være likt for Dører
     static Color farge = Color.LIGHTYELLOW;
     static double tykkelse = 3;


    public Dør(double x1, double y1, Retning r) {
        super(x1, y1, r);
    }


    @Override
    void oppdater() {
        setStroke(farge);
        setStrokeWidth(tykkelse);
    }


    static void setFarge(Color f) {
        if(f != null) {
            farge = f;
        }
    }


    static void setTykkelse(double t) {
        if (tykkelse > 0) tykkelse = t;
    }


}
