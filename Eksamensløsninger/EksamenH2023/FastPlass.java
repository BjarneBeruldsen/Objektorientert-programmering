public class FastPlass extends UtleieObjekt{
	final static int MAX_ANTALL = 699; 
	final static int MIN_ANTALL = 201; 
	static int fastPlassId = MIN_ANTALL; 
	
	
	public FastPlass(){
		id = fastPlassId++; 
		if(!sjekkMellom(id, MAX_ANTALL, MIN_ANTALL)) {
			throw new IllegalArgumentException("Antall fastplass " + id + " er ikke lovlig"); 
		}
	}


	@Override 
	public String toString() {
		return "FAST PLASS " + super.toString(); 
	}

}

