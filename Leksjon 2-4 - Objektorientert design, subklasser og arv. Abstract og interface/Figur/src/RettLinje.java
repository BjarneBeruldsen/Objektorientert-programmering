/**
 * Klassen RettLinje representerer en rett linje i et 2D-koordinatsystem og arver
 * fra klassen Linje.
 * 
 * - Konstruktør: Initialiserer linjen med start- og sluttpunkter (x, y) og (x2, y2),
 *   samt farge og informasjon om den har farge.
 * 
 * - Metoder:
 *   - linjefarge(): Returnerer om linjen har farge (boolean).
 *   - lengde(): Beregner lengden av linjen ved å bruke Pythagoras' teorem, 
 *     og returnerer avstanden mellom start- og sluttpunktene.
 *   - areal(): Returnerer 0, da en linje ikke har noe areal.
 *   - omkrets(): Returnerer 0, da en linje ikke har noen omkrets.
 */


public class RettLinje extends Linje{
    public RettLinje(int x, int y, int x2, int y2, String farge, boolean harFarge) {
        super(x, y, x2, y2, farge, harFarge);
    }

    @Override
    public boolean linjefarge() {
        return harFarge;
    }

    @Override
    //Metode som returnerer distanse mellom to punkter
    public float lengde() {
        //tenker på punktene som en rettvinklet trekant
        //finner katetene
        double k1;
        double k2;
        if(x > x2) {
            k1 = x - x2;
        }
        else {
            k1 = x2 - x;
        }

        if(y > y2) {
            k2 = y - y2;
        }
        else {
            k2 = y2 - y;
        }


        //beregner distanse (hypotenusen)
        float distanse = (float)Math.sqrt((k1*k1) + (k2*k2));

        return (float)distanse;
    }

    @Override
    public float areal() {
        return 0;
    }

    @Override
    public float omkrets() {
        return 0;
    }

}
