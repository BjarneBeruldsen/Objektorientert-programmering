/**
 * Klassen Konto representerer en bankkonto med informasjon om kontonummer, 
 * balanse, rente og en dato.
 * 
 * - Konstruktør: Oppretter en konto med angitte verdier for kontonummer, balanse, 
 *   rente og dato.
 * 
 * - Metoder: 
 *   - Settere og gettere for kontoens variabler.
 *   - trekkFra(double beløp): Trekker fra et spesifisert beløp fra saldoen.
 *   - hentBeløp(double beløp): Legger til et spesifisert beløp til saldoen.
 *   - toString(): Returnerer kontoinformasjon som en formatert streng.
 */


import java.time.LocalDate;

public class Konto {
    protected long kontoNr;
    protected double balanse;
    protected double rente;
    protected Dato dato;

    //konstruktør
    public Konto(long kontoNr, double balanse, double rente, Dato dato) {
        setKontoNr(kontoNr);
        setBalanse(balanse);
        setRente(rente);
        setDato(dato);
    }


    //set og get metoder

    public void setKontoNr(long kontoNr) {
        this.kontoNr = kontoNr;
    }

    public long getKontoNr() {
        return kontoNr;
    }

    public void setBalanse(double balanse) {
        this.balanse = balanse;
    }

    public double getBalanse() {
        return balanse;
    }

    public void setRente(double rente) {
        this.rente = rente;
    }

    public double getRente() {
        return rente;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public Dato getDato() {
        return dato;
    }

    //metode for å trekke fra beløp
    public void trekkFra(double beløp) {
        balanse = balanse - beløp;
    }

    //metode for å hente beløp til konto
    public void hentBeløp(double beløp) {
        balanse = balanse + beløp;
    }

    //toString metode
    @Override
    public String toString() {
        return kontoNr+";"+balanse+";"+rente+";"+dato;
    }
}
