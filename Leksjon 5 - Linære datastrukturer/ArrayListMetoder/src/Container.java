/*
 * Denne klassen representerer en container som kan lagre objekter med en maksimal totalvekt 
 * på 10 kg. Den har metoder for å sjekke om det er plass til nye objekter, legge til objekter, 
 * og for å returnere en strengrepresentasjon av innholdet i containeren.
 * Konstruktøren initialiserer containeren med et unikt nummer.
 */


import java.util.ArrayList;

public class Container {
    //instansvariabler
    private int nr;
    private final static int MAX_KG = 10;
    private ArrayList<Integer> innhold = new ArrayList<>();

    //konstruktør
    public Container(int nr) {
        this.nr = nr;
        innhold = new ArrayList<>();
    }


    //metode som sjekker om det er plass i container
    public boolean harPlass(int kg) {
        int sum = 0;
        //finner sum
        for(int tall: innhold) {
            sum += tall;
        }
        return (sum + kg) <= MAX_KG;
    }

    //add metode
    public void leggTil(int kg) {
        if(harPlass(kg)) {
            innhold.add(kg);
        }
        else {
            throw(new IllegalArgumentException("Container er full!"));
        }
    }

    //toString metode
    public String toString() {
        String ut = "Container nr " + nr + " contains objects with weight: ";
        for(int vekt: innhold) {
            ut += vekt + " ";
        }
        return ut;
    }
}
