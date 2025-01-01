//Tester figur-klassene. 

public class FigurTest {
    public static void main(String[] args) {
        //konstant for maks antall figurer
        final int MAX_FIGUR = 50;

        //Oppretter sirkel objekt
        Sirkel s1 = new Sirkel(50, 50, "Blå", true,  (float) 10.5);
        //Oppretter enda et sirkel objekt
        Sirkel s2 = new Sirkel(50, 50, "Blå", true,  (float) 10.5);
        //skriver ut sirkel objekt
        System.out.println(s1.toString());

        //Oppretter rektangel objekt
        Rektangel r1 = new Rektangel(100, 100, "Rød",
                true, (float) 50.50, (float) 50.50);
        //Oppretter enda et rektangel objekt
        Rektangel r2 = new Rektangel(100, 100, "Rød",
                true, (float) 50.50, (float) 50.50);

        //sorterer rektangel tabell
        Rektangel[] rektangler = {
                new Rektangel(100, 100, "Rød", true, 50, 50),
                new Rektangel(100, 100, "Rød", true, 51, 50),
                new Rektangel(100, 100, "Rød", true, 52, 50),
                new Rektangel(100, 100, "Rød", true, 49, 50)
        };
        java.util.Arrays.sort(rektangler);
        for(Rektangel r: rektangler) {
            System.out.println(r.toString());
        }



        //lage mange figurer både sirkeler og rektangeler

        //tabell for både rektangel og sirkeler
        Figur[] figurTab = new Figur[MAX_FIGUR];

        int antallFigurer = 0;

        figurTab[antallFigurer++] = new Sirkel(200, 200,
                                        "Grønn", true, (float) 10.50);
        System.out.println("Antall figurer i tabell: " + antallFigurer + '\n' +
                            figurTab[0].toString());
        String erLikS;
        //tester equals metoder
        if(s1.equals(s2)) {
            erLikS = "er lik";
        }
        else {
            erLikS = "er ikke lik";
        }

        String erLikR;
        if(r1.equals(r2)) {
            erLikR = "er lik";
        }
        else {
            erLikR = "er ikke lik";
        }

        //tester areal metoder
        float arealR = r1.areal();
        float arealS = s1.areal();

        System.out.println("Sirkel 1 " + erLikS + " " + "Sirkel 2" + '\n' +
                           "Rektangel 1" + " " + erLikR + " Rektangel 2");

        //Skriver ut med formatering
        System.out.printf("Sirkel 1 sitt areal er: %.2f", arealS);
        System.out.println();
        System.out.printf("Rektangel 1 sitt areal er: %.2f", arealR);


    }
}