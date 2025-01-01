/**
 * Representerer en person med kontaktinformasjon.
 * 
 * Instansvariabler:
 * - navn: Personens navn.
 * - tlf: Telefonnummer.
 * - adresse: Bosted.
 * - mail: E-postadresse.
 * 
 * Konstruktør:
 * - Person(String navn, int tlf, String adresse, String mail): Initialiserer en person.
 * 
 * Metoder:
 * - setNavn, setAdresse, setMail, setTlf: Setter verdier.
 * - getNavn: Henter navnet.
 * - kunTall: Sjekker om tlf inneholder kun tall.
 * - toString: Returnerer personens data som en streng.
 */


public class Person {
    //instansvariabler
    protected String navn;
    protected int tlf;
    protected String adresse;
    protected String mail;

    //konstruktør
    public Person(String navn, int tlf, String adresse, String mail) {
        setNavn(navn);
        setTlf(tlf);
        setAdresse(adresse);
        setMail(mail);
    }

    //set og get metoder

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTlf(int tlf) {
        if(kunTall(""+tlf)) {
            this.tlf = tlf;
        }
        else {
            throw new IllegalArgumentException("Tlf kan kun inneholde tall!");
        }
    }

    public String getNavn() {
        return navn;
    }

    //metode som sjekker om tlf nummer kun inneholder tall
    public boolean kunTall(String tall) {
        try {
            Integer.parseInt(tall);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    //toString metode
    public String toString() {
        return navn+";"+tlf+";"+adresse+";"+mail;
    }
}
