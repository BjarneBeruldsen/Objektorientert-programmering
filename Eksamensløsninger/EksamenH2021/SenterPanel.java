package com.example.oppgave1;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author lonnesta
 */
public class SenterPanel extends Pane{

    Element elm;
    ArrayList<Element> ale = new ArrayList<>();

    public SenterPanel(){
        setStyle("-fx-background-color: white; "
                + "-fx-border-width: 2px;"
                + "-fx-border-color: green");
        this.setOnMousePressed(e -> pressed(e));
    }

    protected void pressed(MouseEvent e){
        int x = (int) e.getX();
        int y = (int) e.getY();
        String sElement = Husdesign.elementValg;
        String sRetning = Husdesign.retningValg;
        Retning retning = Retning.NORD;
        if (sElement == null || sRetning == null) return;
        switch (sRetning) {
            case "ØST": retning = Retning.ØST; break;
            case "NORDØST": retning = Retning.NORDØST; break;
            case "NORD": retning = Retning.NORD; break;
            case "NORDVEST": retning = Retning.NORDVEST; break;
            default: System.out.println("Retning: " + sRetning);
        }
        switch (sElement) {
            case "VEGG": elm = new Vegg(x, y, retning); break;
            case "DØR": elm = new Dør(x, y, retning); break;
            case "VINDU": elm = new Vindu(x, y, retning); break;
            case "VALG":  break;
            default: System.out.println("Element: " + sElement);
        }
        if (elm != null) {
            getChildren().add(elm);
            ale.add(elm);
            setOnMouseDragged(ev -> dragged(ev));
        }
    }

    protected void dragged(MouseEvent e){
        int x = (int) e.getX();
        int y = (int) e.getY();
        if (elm != null) elm.drag(x, y);
    }
}