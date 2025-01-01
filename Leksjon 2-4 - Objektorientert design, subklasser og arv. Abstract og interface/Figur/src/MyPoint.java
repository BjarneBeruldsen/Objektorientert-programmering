/**
 * Klassen MyPoint representerer et punkt i et 2D-koordinatsystem med x- og y-koordinater.
 * 
 * - Instansvariabler: x og y representerer koordinatene til punktet.
 * 
 * - Konstruktører:
 *   - En som tar inn spesifikke x- og y-verdier.
 *   - En standardkonstruktør som oppretter punktet (0, 0).
 * 
 * - Metoder:
 *   - Settere og gettere for x og y.
 *   - distanse(MyPoint p1, MyPoint p2): Statisk metode som beregner avstanden
 *     mellom to punkter ved å bruke Pythagoras' teorem.
 *   - toString(): Returnerer en strengrepresentasjon av punktets koordinater.
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

