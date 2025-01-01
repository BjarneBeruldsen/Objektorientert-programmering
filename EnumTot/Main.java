public class Main {

    public static void main(String[] args) {

        for(DagerIUken dag: DagerIUken.values()) {
            System.out.println(dag + " Nivå: " + dag.nivå);
        }
    }
}