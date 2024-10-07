/**
 * Klassen LønnsKonto representerer en spesialisert bankkonto som tillater overtrekk
 * opp til en angitt grense.
 * 
 * - Arver fra Konto-klassen og inkluderer en instansvariabel for overtrekksgrensen.
 * 
 * - Konstruktør: Oppretter en LønnsKonto med angitte verdier for kontonummer, balanse, 
 *   rente, dato og overtrekksgrense.
 * 
 * - Metoder:
 *   - setOvertrekksgrense(double overtrekksgrense): Setter grensen for overtrekk.
 *   - getOvertrekksgrense(): Returnerer overtrekksgrensen.
 *   - trekkFra(double beløp): Trekker fra et spesifisert beløp fra saldoen, men sjekker
 *     først om det vil overskride overtrekksgrensen.
 */

public class LønnsKonto extends Konto{
    //instansvariabler
    protected double overtrekksgrense;
    public LønnsKonto(long kontoNr, double balanse, double rente, Dato dato, double overtrekksgrense) {
        super(kontoNr, balanse, rente, dato);
        setOvertrekksgrense(overtrekksgrense);
    }

    //set og get metoder

    public void setOvertrekksgrense(double overtrekksgrense) {
        this.overtrekksgrense = overtrekksgrense;
    }

    public double getOvertrekksgrense() {
        return overtrekksgrense;
    }

    //metode for å trekke fra beløp
    @Override
    public void trekkFra(double beløp) {
        if(balanse - beløp < overtrekksgrense) {
            System.out.println("Balansen overstiger overtrekksgrensen til lønnskonto!");
        }
        else {
            balanse = balanse - beløp;
        }
    }

}
