public enum DagerIUken {
    MANDAG(0),
    TIRSDAG(10),
    ONSDAG(30),
    TORSDAG(60),
    FREDAG(100),
    LØRDAG(100),
    SØNDAG(60);

    final int nivå;

    DagerIUken (int nivå) {
        this.nivå = nivå;
    }
}
