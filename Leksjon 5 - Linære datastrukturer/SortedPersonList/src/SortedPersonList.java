/*
 * Denne klassen representerer en sortert liste av Person-objekter. Den bruker en LinkedList 
 * til å lagre personene og inkluderer metoder for å legge til nye personer, som automatisk 
 * sorterer listen, samt en metode for å skrive ut innholdet i listen.
 */


import java.util.Collections;
import java.util.LinkedList;

public class SortedPersonList {
    //instansvariabler
    public LinkedList<Person> personListe;
    
    //konstruktør 
    public SortedPersonList() {
        personListe= new LinkedList<>();
    }

    //metode som legger til person og deretter sorterer listen
    public void leggTil(Person p) {
        personListe.add(p);
        Collections.sort(personListe);
    }

    //metode som skriver ut listen
    public void skrivUt() {
        for(Person p: personListe) {
            System.out.println(p);
        }
    }

}
