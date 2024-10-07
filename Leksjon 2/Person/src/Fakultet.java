/**
 * Klassen Fakultet representerer en ansatt ved en utdanningsinstitusjon med tilleggsdetaljer.
 * 
 * - Instansvariabler:
 *   - kontorTimer: Antall kontortimer per uke (int).
 *   - rank: Rangering eller stilling (int).
 * 
 * - Konstruktør:
 *   - Fakultet(String navn, int tlf, String adresse, String mail, 
 *              long personNr, int lønnstrinn, int kontorTimer, int rank):
 *     Initialiserer en Fakultet-ansatt med nødvendige detaljer.
 * 
 * - Metoder:
 *   - toString(): Returnerer en strengrepresentasjon av fakultetets navn.
 */


public class Fakultet extends Ansatt{
    //instansvariabler
    protected int kontorTimer;
    protected int rank;

    public Fakultet(String navn, int tlf, String adresse, String mail,
                    long personNr, int lønnstrinn, int kontorTimer, int rank) {
        super(navn, tlf, adresse, mail, personNr, lønnstrinn);
        this.kontorTimer = kontorTimer;
        this.rank = rank;
    }

        @Override
        public String toString() {
            return "Fakultet.class " + this.getNavn();
        }
}
