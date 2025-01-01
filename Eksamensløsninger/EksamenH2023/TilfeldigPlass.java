public class TilfeldigPlass extends UtleieObjekt{
	final static int MAX_ANTALL = 199; 
	final static int MIN_ANTALL = 101; 
	static int tilfeldigId = MIN_ANTALL; 
	protected final static int MAX_KM = 200; 
	protected final static int MIN_KM = 10; 
	protected final static int MIN_ATTRAKTIVITET = 50; 
	protected final static int MAX_ATTRAKTIVITET = 200; 

	protected int km; 
	protected int attraktivitet; 

	public TilfeldigPlass (int km, int attraktivitet) {
		setKm(km); 
		setAttraktivitet(attraktivitet); 
		id = tilfeldigId++; 
		if(!(sjekkMellom(id, MAX_ANTALL, MIN_ANTALL))) {
			throw new IllegalArgumentException("Antall tilfeldig plasser: " + id + " er ikke lovlig");
		}
	}

	public void setKm(int km) {
		if(! (sjekkMellom(km, MAX_KM, MIN_KM))) {
			throw new IllegalArgumentException("Antall kvadr.meter: " + km + " er ikke lovlig");
		}
		this.km = km;
	}

	public int getKm() { return km; }

	public void setAttraktivitet(int attraktivitet) {
		if(! (sjekkMellom(attraktivitet, MAX_ATTRAKTIVITET, MIN_ATTRAKTIVITET))) {
			throw new IllegalArgumentException("Attraktivitet: " + attraktivitet + " er ikke lovlig");
		}
		this.attraktivitet = attraktivitet;
	}

	public int getAttraktivitet() { return attraktivitet; }
	

	@Override 
	public String toString() {
		return "TILFELDIGPLASS " + super.toString() + " Kvad.M: " + km + " attraktivitet: " + attraktivitet;  
		
	}

}
