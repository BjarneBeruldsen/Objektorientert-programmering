public class TimeOppdrag extends Oppdrag {
	final static String OPPDRAG_TYPE = "Time-Oppdrag";
	protected int leieTid; 
	protected int minVolum = 0;
	
	public TimeOppdrag(String adresse, int leieTid) {
		super(adresse);
		setLeieTid(leieTid); 
	}

	public void setLeieTid(int leieTid) {
		if(leieTid < 0) {
			throw new IllegalArgumentException("Ugyldig leietid");
		}
		this.leieTid = leieTid;
	}
	
	public int minsteVolum() {
		return minVolum; 
	} 
	
	public double pris() {
		return leieTid * container.getPrisPrTime(); 
	}
	
	//toString metode 
	@Override
	public String toString() {
		return OPPDRAG_TYPE + super.toString(); 
	}
}