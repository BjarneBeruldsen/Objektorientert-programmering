/* Klassen Rektangel representerer et rektangel med bredde, høyde og en posisjon (x, y) i et 2D-plan. 
 * Den har to konstruktører: én som lar deg spesifisere verdiene for x, y, bredde og høyde, 
 * og én som bruker standardverdier. Klassen har getter- og setter-metoder for alle attributtene. 
 * Den inneholder også metoder for å beregne arealet og omkretsen av rektangelet, 
 * samt en metode som sjekker om to rektangler kolliderer. 
 * Klassen har en toString()-metode som returnerer rektangelets egenskaper som en formatert streng.
 *
 */

public class Rektangel {
    //instansvariabler
    private double bredde;
    private double høyde;
    private int x;
    private int y;

    //Konstruktør
    public Rektangel(int x, int y, double bredde, double høyde) {
        this.bredde = bredde;
        this.høyde = høyde;
        this.x = x;
        this.y = y;
    }

    //No arg konstruktør som lager default verdi til rektangel
    public Rektangel() {
        this(100, 100, 100, 100);
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

    public void setHøyde(double høyde) {
        this.høyde = høyde;
    }
    public double getHøyde() {
        return høyde;
    }

    public void setBredde(double bredde) {
        this.bredde = bredde;
    }
    public double getBredde() {
        return bredde;
    }


    //metode som returnerer arealet av rektangelet
    public double Areal() {
        double areal = this.bredde*this.høyde;
        return areal;
    }

    //metode som returnerer omkretsen av rektangelet
    public double Omkrets() {
        double omkrets = bredde+høyde+bredde+høyde;
        return omkrets;
    }

    //Kollisjonsmetode som sjekker om to rektangel kolliderer
    public boolean Kollisjon (Rektangel r) {
        //Sjekker om rektangelene kolliderer vertikalt og horisontalt
        boolean kollisjonX = r.x + r.bredde < this.x && this.x + this.bredde < r.x;
        boolean kollisjonY = r.y + r.høyde < this.y && this.y + this.høyde < r.y;
        return kollisjonX && kollisjonY;
    }

    //toString metode
    public String toString() {
        return x+";"+y+";"+bredde+";"+høyde;
    }




}
