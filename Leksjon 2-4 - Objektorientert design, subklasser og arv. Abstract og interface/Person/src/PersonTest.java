//tester personklassene


public class PersonTest {
    public static void main(String[] args) {
        Person s1 = new Student("Bjarne", 48228918, "Grimstad",
                            "Mail", 123, Student.SOPHOMORE);
        Person a1 = new Ansatt("Jon", 12345678, "Bø",
                             "12341234mail", 123421, 2);

        //utskrift av objekter
        System.out.println(s1.toString() + '\n' +
                           a1.toString());
    }
}