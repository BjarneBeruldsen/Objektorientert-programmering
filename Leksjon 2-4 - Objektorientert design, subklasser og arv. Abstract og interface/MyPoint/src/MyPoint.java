/**
 * Klassen MyPoint representerer et punkt i 2D-rommet med x- og y-koordinater.
 * 
 * - Instansvariabler: x og y, begge av typen double.
 * 
 * - Konstruktører:
 *   - MyPoint(double x, double y): Initialiserer punktet med spesifikke koordinater.
 *   - MyPoint(): Lager et punkt med koordinatene (0,0).
 * 
 * - Metoder:
 *   - setX(int x): Setter x-koordinaten.
 *   - getX(): Returnerer x-koordinaten.
 *   - setY(int y): Setter y-koordinaten.
 *   - getY(): Returnerer y-koordinaten.
 *   - distanse(MyPoint p1, MyPoint p2): Beregner avstanden mellom to punkter.
 *   - toString(): Returnerer en strengrepresentasjon av punktet i formatet "x;y".
 */


public class MyPoint {
    //instansvariabler
    protected double x;
    protected double y;

    //konstruktører
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //konstukrør som oppretter punkt 0,0
    public MyPoint() {
        this(0, 0);
    }

    //set og get metoder

    public void setX(int x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }



    //Metode som returnerer distanse mellom to punkter
    public static double distanse(MyPoint p1, MyPoint p2) {
        //tenker på punktene som en rettvinklet trekant
        //finner katetene
        double k1 = p2.x - p1.x;
        double k2 = p2.y - p1.y;

        //beregner distanse (hypotenusen)
        double distanse = Math.sqrt((k1*k1) + (k2*k2));

        return distanse;
    }
    //toString metode
    public String toString() {
        return x+";"+y;
    }
}
