/* Klassen KlSlett representerer et klokkeslett med timer og sekunder. 
 * Den har to konstruktører: én som tar imot timer og sekunder som heltall, 
 * og én som tar imot klokkeslettet som en streng i formatet "HH
 *". Klassen inneholder metoder for å validere om klokkeslettet er gyldig, 
 * sammenligne om to klokkeslett er like eller om ett er før et annet. 
 * Den har også en toString()-metode som returnerer klokkeslettet som en formatert streng i "HH
"-format.
 */
public class KlSlett {
    //Klasse variabler
    private int timer;
    private int sekund;

    //Konstruktør for oppretting av klokkeslett med int.
    public KlSlett(int timer, int sekund) {
        if(erGyldig(timer, sekund)) {
            this.timer = timer;
            this.sekund = sekund;
        }
        else {
            throw new IllegalArgumentException("Feil format!");
        }
    }

    //Konstruktør som tar imot string
    public KlSlett(String klokkeSlett) {
        String[] data = klokkeSlett.split(":");
        timer = Integer.parseInt(data[0]);
        sekund = Integer.parseInt(data[1]);
        if(erGyldig(timer, sekund)) {
            this.timer = timer;
            this.sekund = sekund;
        }
        else {
            throw new IllegalArgumentException("Feil format!");
        }
    }

    //Sjekker om det er gyldig format
    public boolean erGyldig(int timer, int sekund) {
        return timer >= 0 && sekund >= 0 &&
                timer <= 23 && sekund <= 59;
    }


    //equals metode for sammenligning av sekund objekt.
    public boolean erLik(KlSlett k) {
        return sekund == k.sekund && timer == k.timer;
    }

    //metode som sjekker om et klokkeslett er før et annet
    public boolean erFør(KlSlett k) {
        if(this.timer < k.timer) {
            return true;
        }
        else if(this.timer == k.timer && this.sekund < k.sekund) {
            return true;
        }
        else {
            return false;
        }
    }

    public String formatStreng(int timer, int sekund) {
        String timerS;
        String sekundS;
        if(timer < 10) {
            timerS = "0"+timer;
        }
        else {
            timerS = ""+timer;
        }

        if(sekund < 10) {
            sekundS = "0"+sekund;
        }
        else {
            sekundS = ""+sekund;
        }

        return(timerS+":"+sekundS);
    }

    //toString metode for utskrift av klokkeslett
    public String toString() {
        return formatStreng(timer, sekund);
    }
}
