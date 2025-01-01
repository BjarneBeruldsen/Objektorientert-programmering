/**
 * Klassen Ansatt representerer en ansatt person med tilknyttede detaljer.
 * 
 * - Instansvariabler:
 *   - personNr: Unik identifikator for ansatte (long).
 *   - lønnstrinn: Angir lønnstrinnet (int).
 * 
 * - Konstruktør:
 *   - Ansatt(String navn, int tlf, String adresse, String mail, long personNr, int lønnstrinn):
 *     Initialiserer en ansatt med navn, telefonnummer, adresse, e-post, personnummer og lønnstrinn.
 * 
 * - Metoder:
 *   - setPersonNr(long personNr): Setter personnummeret.
 *   - setLønnstrinn(int lønnstrinn): Setter lønnstrinnet.
 *   - getPersonNr(): Returnerer personnummeret.
 *   - getLønnstrinn(): Returnerer lønnstrinnet.
 *   - toString(): Returnerer en strengrepresentasjon av ansattens navn.
 */


public class Ansatt extends Person{
    //instansvariabler
    protected long personNr;
    protected int lønnstrinn;

    //konstruktør
    public Ansatt(String navn, int tlf, String adresse, String mail, long personNr, int lønnstrinn) {
        super(navn, tlf, adresse, mail);
        setPersonNr(personNr);
        setLønnstrinn(lønnstrinn);
    }

    //set og get metoder

    public void setPersonNr(long personNr) {
        this.personNr = personNr;
    }

    public void setLønnstrinn(int lønnstrinn) {
        this.lønnstrinn = lønnstrinn;
    }

    public long getPersonNr() {
        return personNr;
    }

    public int getLønnstrinn() {
        return lønnstrinn;
    }

    @Override
    public String toString() {
        return "Ansatt.class " + this.getNavn();
    }
}
