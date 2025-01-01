public class Container implements Comparable<Container>{
	static int nesteContainerId = 1; 
	protected int containerId; 
	protected int volum;  
	protected double prisPrTime; 
	final static int MAXVOLUM = 100; 
	final static double MAXTIMEPRIS = 10000.0;
	
	public Container(int volum, double prisPrTime) {
		this.containerId = nesteContainerId++; 
		setVolum(volum); 
		setPrisPrTime(prisPrTime); 
	}
	
	//set metoder 
	public void setVolum(int v) {
		if(v <= 0 || v > MAXVOLUM) {
			throw new IllegalArgumentException("Volum: " + v + 
												" er ikke lovlig"); 
		}
		this.volum = v; 
	}
	
	public void setPrisPrTime(double p) {
		if(p < 0 || p > MAXTIMEPRIS) {
			throw new IllegalArgumentException("Timepris: " + p + 
												" er ikke lovlig"); 
		}
		this.prisPrTime = p; 
	}
	
	//get metoder 
	public int getVolum() {
		return volum; 
	}
	
	public double getPrisPrTime() {
		return prisPrTime; 
	}
	
	public int getContainerId() {
		return containerId; 
	}
	
	//compare metode 
	public int compareTo(Container c) {
		return volum - c.volum;  
	}
	
	//toString metode 
	public String toString() {
		return "løpe.nr: " + containerId + " volum: " + 
						volum + " pris: " + prisPrTime; 
	}
	
}