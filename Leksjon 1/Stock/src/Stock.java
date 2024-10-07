/*
 * Klassen Stock representerer en aksje med et symbol og navn,
 * samt priser fra gårsdagen og nåtiden.
 * 
 * - Den har en konstruktør som oppretter en aksje basert på symbol og navn.
 * - Set-metoder brukes for å sette gårsdagens og nåværende pris.
 * - Klassen inneholder en metode som beregner prosentvis endring mellom prisene.
 * - toString()-metoden returnerer aksjens informasjon som en formatert streng.
 */

public class Stock {
    //Objektvariabler
    private String symbol, name;
    //lagrer gårsdagens stock pris
    private double previousClosingPrice;
    //lagrer nåtidens stockpris
    private double currentPrice;


    //Konstruktør som oppretter en spesifikk stock med symbol og navn
    public Stock (String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    //set metoder for priser
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    //Metode som returnerer prosent endring fra prisen i går til nåtidens pris
    public double getChangePercent() {
        //regner ut endring i prosent
        double differanse = this.currentPrice - this.previousClosingPrice;
        return (differanse*100) / this.previousClosingPrice;
    }
    //toString metode
    public String toString() {
        return symbol+";"+name+";"+previousClosingPrice+";"+currentPrice;
    }
}
