//tester sortering av persontab. 

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person p1 = new Person("Bjarne", 48228918, "Lia 1", "Mail");
        Person p2 = new Person("cjarne", 48228918, "Lia 1", "Mail");
        Person p3 = new Person("djarne", 48228918, "Lia 1", "Mail");
        Person p4 = new Person("Ajarne", 48228918, "Lia 1", "Mail");
        Person p5 = new Person("bjarne", 48228918, "Lia 1", "Mail");

        SortedPersonList persontab = new SortedPersonList();
        persontab.leggTil(p1);
        persontab.leggTil(p2);
        persontab.leggTil(p3);
        persontab.leggTil(p4);
        persontab.leggTil(p5);



        //skriver ut liste sortert og usortert
        persontab.skrivUt();
    }
}