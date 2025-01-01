public class RektangelTest {
    public static void main(String[] args) {
        Rektangel r1 = new Rektangel();
        Rektangel r2 = new Rektangel(200, 100, 100.0, 100.0);

        System.out.println(r1.toString() + '\n' + r2.toString());
    }
}