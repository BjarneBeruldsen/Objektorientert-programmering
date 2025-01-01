public class KlSlettTest {
    public static void main(String[] args) {
        KlSlett k1 = new KlSlett(8, 15);
        KlSlett k2 = new KlSlett("00:00");

        System.out.println(k1.toString());
        System.out.println(k2.toString());

        String forhold = "";
        if ( k1.erLik(k2) ) {
            forhold = " er lik ";
        }
        else if ( k1.erFør(k2) ) {
            forhold = " er før ";
        }
        else {
            forhold = " er etter ";
        }
        System.out.println(k1.toString() + forhold + k2.toString());
    }
}