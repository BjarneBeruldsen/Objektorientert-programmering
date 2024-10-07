public class StockTest {
    public static void main(String[] args) {
        //Oppretter stock-objekt
        Stock s1 = new Stock("ORCL", "Oracle Corporation");
        s1.setPreviousClosingPrice(34.5);
        s1.setCurrentPrice(34.35);
        double prosentEndring = s1.getChangePercent();


        System.out.println(s1.toString() + '\n'
                + "endring i prosent fra i går til i dag: " + prosentEndring + '%');
    }
}