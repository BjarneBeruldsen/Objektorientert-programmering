import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> tall = new ArrayList<Integer>();
        tall.add(34);
        tall.add(5);
        tall.add(3);
        tall.add(5);
        tall.add(6);
        tall.add(4);
        tall.add(33);
        tall.add(2);
        tall.add(2);
        tall.add(4);



        //kaller på metode som fjerner duplikater
        removeDuplicate(tall);

        tall.clear();
        tall.add(1);
        tall.add(2);
        tall.add(3);
        tall.add(4);
        tall.add(5);

        //tester sammenslåing
        ArrayList<Integer> tall2 = new ArrayList<Integer>();

        tall2.add(6);
        tall2.add(7);
        tall2.add(8);
        tall2.add(9);
        tall2.add(10);

        ArrayList<Integer> slåttSammen = union(tall, tall2);

        //skriver ut tabell
        System.out.println();
        slåttSammen.forEach(e -> System.out.print(e + " "));

        //tester omgjøring fra string til Character Arraylist
        String s = "halopådu";

        ArrayList<Character> bokstaver = toCharacterArray(s);

        System.out.println();
        System.out.println(bokstaver);

        //Oppretter test data
        ArrayList<Integer> tall3 = new ArrayList<>();
        tall3.add(7);
        tall3.add(5);
        tall3.add(2);
        tall3.add(3);
        tall3.add(5);
        tall3.add(8);

        ArrayList<Container> containere = pakkeObjekter(tall3);
        for(Container c: containere) {
            System.out.println(c);
        }
    }



    //metoder
    public static ArrayList<Integer> fusjon(ArrayList<Integer> liste1,
                                            ArrayList<Integer> liste2) {
        //Oppretter ny arraylist
        ArrayList<Integer> ny = new ArrayList<Integer>();

        //legger liste1 til ny ved hjelp av en for-loop
        for(Integer tall: liste1) {
            ny.add(tall);
        }

        //legger liste2 til ny
        for(Integer tall: liste2) {
            ny.add(tall);
        }

        return ny;
    }

    //Oppgave 11.13 Remove duplicates
    //metode som fjerner duplikater og skriver ut liste uten dem i samme
    //rekkefølge som bruker skrev dem inn.
    public static void removeDuplicate(ArrayList<Integer> liste) {
        //oppretter liste
        ArrayList<Integer> liste2 = new ArrayList<Integer>();

        //sjekker om liste inneholde like tall ved hjelp av en til liste
        for(int tall: liste) {
            if(!liste2.contains(tall)) {
                liste2.add(tall);
            }
        }

        //skriver ut tabell
        liste2.forEach(e -> System.out.print(e + " "));
    }

    //Oppgave 11.14 Kombiner to lister
    public static ArrayList<Integer> union(ArrayList<Integer> liste1,
                                           ArrayList<Integer> liste2) {
        //legger liste 1 til liste 2
        liste1.addAll(liste2);

        return liste1;
    }

    //Oppgave 11.18
    public static ArrayList<Character> toCharacterArray(String s) {
        //Gjør om string s til char tabell

        char[] bokstavArray = s.toCharArray();

        //legger bokstaver til liste
        ArrayList<Character> bokstaver = new ArrayList<>();

        for(char bokstav: bokstavArray) {
            bokstaver.add(bokstav);
        }

        return bokstaver;
    }

    //Oppgaven 11.19

    //metode som pakker objekter i containere med maks 10kg
    public static ArrayList<Container> pakkeObjekter(ArrayList<Integer> liste) {
        //oppretter arraylist for å ta vare på containere
        ArrayList<Container> containere = new ArrayList<>();
        containere.add(new Container(1));

        for(int i=0;i<liste.size();i++) {
            int tall = liste.get(i);

            //while løkke som kjører helt til tall er lagt inn
            boolean harLagtInn = false;
            int j = 0;
            while(!harLagtInn) {
                //sjekker om det  er nok
                if(j >= containere.size()){
                    Container nyContainer = new Container(containere.size()+1);
                    containere.add(nyContainer);
                }
                if (containere.get(j).harPlass(tall)) {
                    //legger til visst den har plass
                    containere.get(j).leggTil(tall);
                    harLagtInn = true;
                }
                j++;
            }
        }
        return containere;
    }
}



















