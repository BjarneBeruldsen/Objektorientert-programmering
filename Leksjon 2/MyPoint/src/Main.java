//Tester trekant og mypoint klassene. 

public class Main {
    public static void main(String[] args) {
        MyPoint m1 = new MyPoint(100, 200);
        MyPoint m2 = new MyPoint(200, 100);

        double distansefra3 = MyPoint.distanse(m1, m2);

        //tester trekant
        Trekant t1 = new Trekant(new MyPoint(50, 100), new MyPoint(100, 50),
                     new MyPoint(150, 100));
        double omkrets = t1.omkrets();
        double areal = t1.areal();

        //sjekker om punkt er inne i trekant
        String status;
        MyPoint p1 = new MyPoint(100, 75);
        if(t1.contains(p1)) {
            status = " Ligger inne i ";
        }
        else{
            status = " Ligger ikke inne i ";
        }

        //sjekker om trekanten er inne i denne trekanten
        String status2 = "";
        Trekant t2 = new Trekant(new MyPoint(500, 500), new MyPoint(600, 400),
                            new MyPoint(700, 500));
        if(t1.contains(t2)) {
            status2 = "t2 er inne i t1";
        }
        else {
            status2 = "t2 er ikke inne i t1";
        }

        String status3 = "";
        if(t1.overlaps(t2)) {
            status3 = "t1 overlapper t2";
        }
        else {
            status3 = "t1 overlapper ikke t2";
        }


        //Printf gjør formatering mulig.
        System.out.printf(""+distansefra3 + '\n' +
                            "Trekant omkrets: " + omkrets + '\n' +
                            "Trekant areal: %.2f",  areal);
        System.out.println();
        System.out.println(p1.toString() + status + t1.toString() + '\n' +
                           status2 + '\n' +
                           status3);
        double originalAreal = t1.areal();
        double delAreal1 = new Trekant(t1.getP1(), t1.getP2(), p1).areal();
        double delAreal2 = new Trekant(t1.getP2(), t1.getP3(), p1).areal();
        double delAreal3 = new Trekant(t1.getP3(), t1.getP1(), p1).areal();
        double arealSum = delAreal1 + delAreal2 + delAreal3;

        System.out.println("Originalt areal: " + originalAreal);
        System.out.println("Deltrekant areal 1: " + delAreal1);
        System.out.println("Deltrekant areal 2: " + delAreal2);
        System.out.println("Deltrekant areal 3: " + delAreal3);
        System.out.println("Sum av delarealene: " + arealSum);
    }
}