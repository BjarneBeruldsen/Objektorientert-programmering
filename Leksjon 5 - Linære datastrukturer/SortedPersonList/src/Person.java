/*
 * Denne klassen representerer en person med informasjon som navn, telefonnummer, adresse 
 * og e-post. Den implementerer Comparable-grensesnittet for å sammenligne personer 
 * basert på navn. Klassen inkluderer konstruktør, setter og getter metoder, samt en metode 
 * for å validere telefonnummeret slik at det kun inneholder tall.
 */


public class Person implements Comparable<Person>{
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

    //compareto metode
    public int compareTo(Person p) {
        return this.navn.compareTo(p.navn);
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
