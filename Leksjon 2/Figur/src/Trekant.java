/**
 * Klassen Trekant representerer en trekant i 2D ved hjelp av tre punkter (p1, p2, p3).
 * 
 * - Instansvariabler: p1, p2, p3 av typen MyPoint.
 * 
 * - Konstruktører:
 *   - Trekant(MyPoint p1, MyPoint p2, MyPoint p3): Initialiserer trekanten med spesifikke punkter.
 *   - Trekant(): Lager en standard trekant med punktene (0,0), (1,1), (2,5).
 * 
 * - Metoder:
 *   - omkrets(): Beregner omkretsen av trekanten.
 *   - areal(): Beregner arealet av trekanten.
 *   - contains(MyPoint p): Sjekker om et punkt ligger innenfor trekanten.
 *   - contains(Trekant t): Sjekker om en annen trekant ligger innenfor denne trekanten.
 *   - overlaps(Trekant t): Sjekker om denne trekanten overlapper med en annen trekant.
 *   - toString(): Returnerer en strengrepresentasjon av trekanten.
 */


public class Trekant {
    //instansvariabler
    protected MyPoint p1, p2, p3;

    //Konstruktører mypoint
    public Trekant(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    //No-arg konstruktør som lager default trekant
    public Trekant() {
        this(new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(2, 5));
    }

    //set og get metoder

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP1() {
        return p1;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }

    public MyPoint getP3() {
        return p3;
    }

    //metode som regner ut omkretsen av trekanen
    public double omkrets() {
        //finner distanse på de tre sidene
        //bruker metode fra MyPoint klassen
        double s1 = MyPoint.distanse(p1, p2);
        double s2 = MyPoint.distanse(p2, p3);
        double s3 = MyPoint.distanse(p3, p1);

        double omkrets = s1+s2+s3;

        return omkrets;
    }

    //metode som returnerer arealet av en trekant
    public double areal() {
        double s1 = MyPoint.distanse(p1, p2);
        double s2 = MyPoint.distanse(p2, p3);
        double s3 = MyPoint.distanse(p3, p1);
        double s = (s1+s2+s3) / 2;
        return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
    }

    //metode som sjekker om punkt er i trekant
    public boolean contains(MyPoint p) {
        //lager tre nye trekanter
        Trekant t1 = new Trekant(this.getP1(), this.getP2(), p);
        Trekant t2 = new Trekant(this.getP2(), this.getP3(), p);
        Trekant t3 = new Trekant(this.getP3(), this.getP1(), p);

        //sjekker om arealene tilsammen er lik arealet av denne trekanten
        double arealSum = t1.areal() + t2.areal() + t3.areal();

        //runder av til int for å fjerne unøyaktige desimaler
        return (int)(arealSum) + 0.5 == (int)(this.areal()) + 0.5;
    }

    //metode som sjekker om hele trekanten er inne i denne trekanten m
    public boolean contains(Trekant t) {
        return this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3);
    }

    //metode som sjekker om trekantene overlapper hverandre
    public boolean overlaps(Trekant t) {
        return this.contains(t.p1) || this.contains(t.p2) || this.contains(t.p3);
    }

    //toString metode
    @Override
    public String toString() {
        return p1.toString() + ";" + p2.toString() + ";" + p3.toString();
    }
}

