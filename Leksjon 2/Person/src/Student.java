/*
 * Representerer en student med et unikt studentnummer og status (f.eks. freshman, sophomore, junior, senior).
 * Arver fra Person-klassen, inkludert attributter som navn, telefonnummer, adresse og e-post.
 */

public class Student extends Person{
    //instansvariabler
    protected final String STATUS;

    public static final String FRESHMAN = "freshman";
    public static final String SOPHOMORE = "sophomore";
    public static final String JUNIOR = "junior";
    public static final String SENIOR = "senior";

    protected long studentNr;

    //Konstruktør
    public Student(String navn, int tlf, String adresse, String mail, long studentNr, String STATUS) {
        super(navn, tlf, adresse, mail);
        setStudentNr(studentNr);
        this.STATUS = STATUS;
    }

    //set og get metoder

    public void setStudentNr(long studentNr) {
        this.studentNr = studentNr;
    }

    public long getStudentNr() {
        return studentNr;
    }

    @Override
    public String toString() {
        return "Student.class " + this.getNavn();
    }
}
