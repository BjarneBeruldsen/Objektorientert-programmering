public abstract class Oppdrag {
	protected String adresse; 
	protected Container container; 
	
	public Oppdrag(String adresse, Container container) {
		this.adresse = adresse; 
		this.container = container; 
	}
	
	public Oppdrag(String adresse) {
		this(adresse, null);  
	}
	
	//set og get metoder 
	public void setAdresse(String a) {
		this.adresse = a; 
	}
	
	public void setContainer(Container c) {
		this.container = c; 
	}
	
	public String getAdresse() {
		return adresse; 
	}
	
	public Container getContainer() {
		return container; 
	}
	
	//abstrakte metoder til subklasser 
	public abstract int minsteVolum(); 
	
	public abstract double pris(); 

	@Override
	public String toString() {
		return " adresse: " + adresse + 
					 " løpenr: " + container.getContainerId() + " pris: " + this.pris(); 
	}
}