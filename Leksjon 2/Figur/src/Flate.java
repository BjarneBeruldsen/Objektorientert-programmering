/**
 * Den abstrakte klassen Flate er en spesialisering av klassen Figur og representerer 
 * en todimensjonal figur som kan være fylt med farge.
 * 
 * - Instansvariabel: fyll angir om figuren er fylt (true) eller ikke (false).
 * 
 * - Konstruktør: Initialiserer posisjon, farge og fyll for flaten.
 * 
 * - Metoder:
 *   - Abstrakt metode fyllFarge(): Må implementeres av subklasser for å
 *     bestemme fargen på fyllingen, dersom figuren er fylt.
 */



public abstract class Flate extends Figur {

    //instansvariabler
    protected boolean fyll;
    public Flate(int x, int y, String farge, boolean fyll) {
        super(x, y, farge);
        this.fyll = fyll;
    }

    public abstract boolean fyllFarge();

}
