/**
 * Klassen SpareKonto representerer en spesialisert bankkonto for sparing,
 * som ikke tillater overtrekk.
 * 
 * - Arver fra Konto-klassen og bruker konstruktøren for å initialisere kontoens
 *   kontonummer, balanse, rente og dato.
 * 
 * - Metoder:
 *   - trekkFra(double beløp): Trekker fra et spesifisert beløp fra saldoen, men
 *     sjekker først om saldoen er tilstrekkelig. Hvis ikke, gis det en melding om
 *     at kontoen ikke har tilstrekkelig saldo.
 */


public class SpareKonto extends Konto{
    public SpareKonto(long kontoNr, double balanse, double rente, Dato dato) {
        super(kontoNr, balanse, rente, dato);

    }
    //metode for å trekke fra beløp
    @Override
    public void trekkFra(double beløp) {
        if(balanse - beløp < 0) {
            System.out.println("Kontoen har ikke gitt sum!");
        }
        else {
            balanse = balanse - beløp;
        }
    }
}
