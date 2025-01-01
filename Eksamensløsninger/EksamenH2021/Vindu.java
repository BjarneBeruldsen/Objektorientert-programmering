package com.example.oppgave1;

import javafx.scene.paint.Color;

public class Vindu extends Element{
    //Instansvariabler som skal være likt for Vinduer
    static Color farge = Color.LIGHTGRAY;
    static double tykkelse = 3;

    public Vindu(double x, double y, Retning r) {
        super(x, y, r);
    }



    @Override
    void oppdater() {
        setStroke(farge);
        setStrokeWidth(tykkelse);
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
