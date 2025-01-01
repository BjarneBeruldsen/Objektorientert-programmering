/**
 * Representerer en stabmedarbeider med tittel.
 * 
 * Instansvariabler:
 * - tittel: Stabmedarbeiderens tittel.
 * 
 * Konstruktør:
 * - Stab(String navn, int tlf, String adresse, String mail, long personNr, int lønnstrinn, String tittel): 
 *   Initialiserer en stabmedarbeider med kontaktinformasjon og tittel.
 * 
 * Metoder:
 * - toString: Returnerer informasjon om stabmedarbeideren.
 */


public class Stab extends Ansatt{
    //instansvariabler
    protected String tittel;
    public Stab(String navn, int tlf, String adresse,
                String mail, long personNr, int lønnstrinn, String titel) {
        super(navn, tlf, adresse, mail, personNr, lønnstrinn);
        this.tittel = titel;
    }

    @Override
    public String toString() {
        return "Stab.class " + this.getNavn();
    }
}

