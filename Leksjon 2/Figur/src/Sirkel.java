/**
 * Klassen Sirkel representerer en sirkel i et 2D-koordinatsystem og arver fra
 * klassen Flate. Den inkluderer informasjon om sirkelens radius.
 * 
 * - Instansvariabler: radius, som arves x, y og farge fra Figur.
 * 
 * - Konstruktør: Initialiserer sirkelen med posisjon, farge, fyll og radius.
 * 
 * - Metoder:
 *   - Settere og gettere for radius.
 *   - equals(Object o): Sammenligner et annet objekt med dette sirkelen.
 *   - areal(): Beregner arealet av sirkelen ved hjelp av formelen π * r².
 *   - omkrets(): Beregner omkretsen av sirkelen ved hjelp av formelen 2 * π * r.
 *   - toString(): Returnerer en strengrepresentasjon av sirkelen, inkludert 
 *     posisjon, radius og farge.
 *   - fyllFarge(): Returnerer om sirkelen er fylt.
 */


public class Sirkel extends Flate{
    //instansvariabler
    protected float radius; //arver x, y og farge, legger til radius

    //konstruktør
    public Sirkel(int x, int y, String farge, boolean fyll, float radius) {
        super(x, y, farge, fyll);
        this.fyll = fyll;
        setRadius(radius);
    }

    //set og get metoder
    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }


    //equals metode
    @Override
    public boolean equals(Object o) {
        //sjekker om objektet er en sirkel
        if(!(o instanceof Sirkel)) {
            return false;
        }
        //typetvinger objekt til sirkel
        Sirkel s = (Sirkel) o;
        return super.equals(s) && (radius == s.radius);
    }

    //areal metode
    @Override
    public float areal() {
        return (float)Math.PI*2*radius;
    }

    //omkrets metode


    @Override
    public float omkrets() {
        return (float)Math.PI*(radius+radius);
    }

    //toString metode
    @Override //overskriver superklassens toString metode
    public String toString() {
        return "X: " + x + " Y: " + y +
                " Radius: " + radius + " Farge: " + farge;
    }

    @Override
    public boolean fyllFarge () {
        return fyll;
    }
}

