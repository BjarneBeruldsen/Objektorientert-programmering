/**
 * Klassen Rektangel representerer en rektangulær flate i et 2D-plan og arver fra 
 * klassen Flate. Den implementerer også Comparable-grensesnittet for sammenligning
 * av rektangler basert på areal.
 * 
 * - Instansvariabler: høyde og bredde, som arves x, y og farge fra Figur.
 * 
 * - Konstruktør: Initialiserer rektangelet med posisjon, farge, fyll, høyde og bredde.
 * 
 * - Metoder:
 *   - Settere og gettere for høyde og bredde.
 *   - equals(Object o): Sammenligner et annet objekt med dette rektangelet.
 *   - areal(): Beregner arealet av rektangelet.
 *   - omkrets(): Beregner omkretsen av rektangelet.
 *   - toString(): Returnerer en strengrepresentasjon av rektangelet, inkludert 
 *     posisjon, farge, høyde og bredde.
 *   - fyllFarge(): Returnerer om rektangelet er fylt.
 *   - compareTo(Rektangel o): Sammenligner dette rektangelet med et annet basert 
 *     på areal.
 */


public class Rektangel extends Flate
        implements Comparable<Rektangel> {
    //Instansvariabler
    protected float høyde, bredde; //arver x, y og farge fra Figur

    //Konstruktør
    public Rektangel (int x, int y, String farge, boolean fyll, float høyde, float bredde) {
        super(x, y, farge, fyll);
        setBredde(bredde);
        setHøyde(høyde);
    }


    //set og get metoder

    public void setHøyde(float høyde) {
        this.høyde = høyde;
    }

    public float getHøyde() {
        return høyde;
    }

    public void setBredde(float bredde) {
        this.bredde = bredde;
    }

    public float getBredde() {
        return bredde;
    }

    //eguals metode
    @Override
    public boolean equals(Object o) {
        //sjekker om o er rektangel
        if(!(o instanceof Rektangel)) {
            return false;
        }
        //typetvinger o til rekatangel
        Rektangel r = (Rektangel) o;
        return (x == r.y) && (y == r.y) && (farge.equals(r.farge)
                && (bredde == r.bredde) && (høyde == r.bredde));
    }

    //areal metode
    @Override
    public float areal() {
        return (float)bredde*høyde;
    }

    @Override
    public float omkrets() {
        return (float)(bredde*2)+(høyde*2);
    }


    //toString metode for utskrift av rektangel-objekt
    @Override //overskriver figur sin toString metode
    public String toString() {
        return super.toString() +" Bredde: " + bredde +
                                    " Høyde: " + høyde;
    }

    @Override
    public boolean fyllFarge() {
     return fyll;
    }

    @Override
    public int compareTo(Rektangel o) {
        if(areal() > o.areal()) {
            return 1;
        }
        else if(areal() < o.areal()) {
            return -1;
        }
        else{
            return 0;
        }
    }
}
