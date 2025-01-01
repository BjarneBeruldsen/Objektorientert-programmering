public class Hytte extends UtleieObjekt{
	final static int MAX_SENGEPLASS = 10; 
	final static int MIN_SENGEPLASS = 1; 
	final static int MAX_ANTALL = 99; 
	final static int MIN_ANTALL = 1; 
	static int hytteID = MIN_ANTALL; 

	protected int antPlasser; 
		
	public Hytte(int antPlasser) {
		setAntPlasser(antPlasser); 
		id = hytteID++; 
		if(! (sjekkMellom(id, MAX_ANTALL, MIN_ANTALL))) {
			throw new IllegalArgumentException("Antall hytter: " + id + " er ikke lovlig");
		}
	}

	public void setAntPlasser(int antPlasser) {
		if(!sjekkMellom(antPlasser, MAX_SENGEPLASS, MIN_SENGEPLASS)) {
			throw new IllegalArgumentException("Antall plasser: " + antPlasser + " er ikke lovlig");
		}
		this.antPlasser = antPlasser; 
	}

	public int getAntPlasser() {
		return antPlasser; 
	}

	@Override 
	public String toString() {
		return "HYTTE "+super.toString() + " Sengeplasser: " + antPlasser; 
	}
}