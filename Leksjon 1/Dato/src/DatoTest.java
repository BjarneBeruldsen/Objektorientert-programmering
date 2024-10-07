public class DatoTest {
    public static void main(String[] args) {
        Dato d1 = new Dato(10, 1, 2000);
        Dato d2 = new Dato(2, 1, 2000);
        Dato d3 = new Dato(4, 3, 2023);

        //sjekker metoder i klassen Dato
        String forhold = "";
        if ( d1.equals(d2) ) {
            forhold = " er lik ";
        }
        else if ( d1.erFør(d2) ) {
            forhold = " er før ";
        }
        else {
            forhold = " er etter ";
        }

        //sjekker om årene er skudd år
        String skuddår = "";
        if(d3.iSkuddår()) {
            skuddår += '\n' + d3.toString() + " er i et skuddår";
        }
        else {
            skuddår += '\n' + d3.toString() + " er ikke i et skuddår";
        }


        System.out.println(d1.toString() + forhold + d2.toString() + skuddår);
    }
}
