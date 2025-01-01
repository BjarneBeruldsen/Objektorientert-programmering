/**
 * Klassen Rektangel representerer et rektangel i et 2D-plan med bredde, høyde og posisjon (x, y).
 * 
 * - Konstruktører: 
 *   - En som tar inn x, y, bredde og høyde.
 *   - En standardkonstruktør som setter standardverdier.
 * 
 * - Metoder: 
 *   - Settere og gettere for alle instansvariabler.
 *   - Beregner areal og omkrets av rektangelet.
 *   - Sjekker for kollisjon mellom to rektangler.
 *   - toString() returnerer rektangelets egenskaper som en formatert streng.
 */


public class Dato extends Object{
    //Objektklassens variabler
    private int dag;
    private int mnd;
    private int år;

    //konstruktør
    public Dato(int dag, int mnd, int år) {
        //sjekker om verdiene er gyldige
        if(erGyldig(dag, mnd, år)) {
            this.dag = dag;
            this.mnd = mnd;
            this.år = år;
        }
        else {
            throw new IllegalArgumentException("Feil format!");
        }
    }

    //Konstruktør som tar imot string
    public Dato(String datoTekst) {
        //splitter data fra tekstreng  og legger inn i variabler
        String[] data = datoTekst.split(";");
        dag = Integer.parseInt(data[0]);
        mnd = Integer.parseInt(data[1]);
        år = Integer.parseInt(data[2]);
        if(erGyldig(dag, mnd, år)) {
            this.dag = dag;
            this.mnd = mnd;
            this.år = år;
        }
        else {
            throw new IllegalArgumentException("Feil format!");
        }
    }

    //equals metode som sjekker at denne datoen er lik datoen d
    public boolean equals(Dato d) {
        return dag == d.dag && mnd == d.mnd && år == d.år;
    }

    //Metode som sjekker om den ene datoen er før den andre
    public boolean erFør(Dato d) {
        if(this.år < d.år) {
            return true;
        }
        else if(this.år == d.år && this.mnd < d.mnd) {
            return true;
        }
        else if(this.år == d.år && this.mnd == d.mnd && this.dag < d.dag) {
            return true;
        }
        else {
            return false;
        }
    }

    //metode for pent format
    public String format(int dag, int mnd) {
        String dagS, mndS;
        if(dag < 10) {
            dagS = "0"+dag;
        }
        else {
            dagS = ""+dag;
        }

        if(mnd < 10) {
            mndS = "0"+mnd;
        }
        else {
            mndS = ""+mnd;
        }
        return(dagS+"."+mndS);
    }

    //metode som sjekker om datoen er i et skuddår
    public boolean iSkuddår() {
        return(this.år % 4 == 0 && this.år % 100 != 0) || (this.år % 400 == 0);
    }

    //toString metode
    public String toString() {
        return format(dag, mnd)+"."+år;
    }

    //Metode som sjekker om verdiene er gyldige
    public boolean erGyldig(int dag, int mnd, int år) {
        if( (dag >= 1 && dag <= 31) && (mnd >= 1 && mnd <= 12)
                && (år >= 2000 && år <= 2050 ) ) {
            return true;
        }
        else {
            return false;
        }
    }
}
