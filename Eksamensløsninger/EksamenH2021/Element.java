package com.example.oppgave1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public abstract class Element extends Line {
    //Instansvariebler likt for alle subklasser
    Retning retning;

    //Konstruktørmetode
    public Element(double x1, double y1, Retning r) {
        setStartX(x1);
        setStartY(y1);
        setEndX(x1);
        setEndY(y1);
        retning = r;
        oppdater();
    }

    //metode for å fra linje
    public void drag(double x2, double y2) {
        double x1 = getStartX();
        double y1 = getStartY();
        switch (retning) {
            case ØST:
                setEndX(x2);
                setEndY(y1);
                break;
            case NORD:
                setEndX(x1);
                setEndY(y2);
                break;
            case NORDØST:
                double dxy = (x2 - x1 + y1 - y2)/2;
                setEndX(x1 + dxy);
                setEndY(y1 - dxy);
                break;
            case NORDVEST:
                dxy = (x1 - x2 + y1 - y2)/2;
                setEndX(x1 - dxy);
                setEndY(y1 - dxy);
                break;
        }
    }

    //set og get metoder
    abstract void oppdater();

}
