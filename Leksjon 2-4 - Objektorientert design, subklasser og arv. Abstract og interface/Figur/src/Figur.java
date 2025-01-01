/**
 * Den abstrakte klassen Figur representerer en geometrisk figur med posisjon
 * (x, y) og farge.
 * 
 * - Instansvariabler: x og y representerer figurens posisjon, mens farge
 *   angir figurens farge.
 * 
 * - Konstruktør: Initialiserer posisjon og farge for figuren.
 * 
 * - Metoder:
 *   - Settere og gettere for x, y og farge.
 *   - Abstrakte metoder areal() og omkrets() som må implementeres av subklasser.
 *   - equals(Object o): Sammenligner to Figur-objekter for likhet basert på
 *     posisjon og farge.
 *   - toString(): Returnerer en strengrepresentasjon av figurens egenskaper.
 */


public abstract class Figur {
    //instansvariabler
    protected int x, y;     //alle har farge
    protected String farge; //alle har posisjon

    //Konstruktørmetode
    public Figur(int x, int y, String farge) {
        setX(x);
        setY(y);
        setFarge(farge);
    }

    //set og get metoder

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public String getFarge() {
        return farge;
    }

    //abstrakte metoder
    public abstract float areal();
    public abstract float omkrets();

    //equals metode
    @Override
    public boolean equals(Object o) {
        //sjekker om objektet er en figur
        if(!(o instanceof Figur)) {
            return false;
        }
        //typetvinger til figur
        Figur f = (Figur) o;
        return (x == f.x) && (y == f.y) && (farge.equals(f.farge));
    }

    //toString metode
    public String toString() {
        return "X: "+x+" Y: "+y+" Farge: "+farge;
    }
}
