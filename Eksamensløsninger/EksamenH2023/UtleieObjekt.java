public class UtleieObjekt {
	protected int id;   
	
	public int getId(){return id;}
	
	@Override 
	public String toString() {
		return "ID: " + id; 
	}

	//hjelpemetode for å om verdier er mellom to tall
	protected boolean sjekkMellom(int tall, int max, int min) {
		return (tall >= min) && (tall <=max); 
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof UtleieObjekt) ) {
			return false; 
		}
		return id == ((UtleieObjekt)o).id; 
	}
}