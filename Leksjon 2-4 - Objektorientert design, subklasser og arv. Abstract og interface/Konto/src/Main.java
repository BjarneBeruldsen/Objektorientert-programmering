/* Test av konto klassene 
 */
public class Main {
    public static void main(String[] args) {
        //oppretter konto, lønnskonto og sparekonto objekt og skriver dem ut
        Konto k1 = new Konto(1123123123, 1000, 1, new Dato(11, 3, 2000));
        SpareKonto sK1 = new SpareKonto(1123123123, 1000, 1, new Dato(11, 3, 2000));
        LønnsKonto lK1 = new LønnsKonto(1231231322, 1, 1, new Dato(1, 1, 2000), -5000);
        lK1.trekkFra(5002);
        System.out.println("Konto: " + k1.toString() + '\n' +
                           "Sparekonto: " + sK1.toString() + '\n' +
                           "Lønnskonto: " + lK1.toString());
    }
}