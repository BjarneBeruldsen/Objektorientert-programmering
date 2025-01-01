public class DagOppdrag extends Oppdrag {
	protected int minVolum; 
	final static double PRIS_PR_KUBIKK = 600;
	final static String OPPDRAG_TYPE = "Dag-Oppdrag"; 
	
	public DagOppdrag(String adresse, int minVolum) {
		super(adresse); 
		this.minVolum = minVolum; 
	}

	public void setMinVolum(int minVolum) {
		if(minVolum < 0) {
			throw new IllegalArgumentException("Ugyldig min.volum");
		}
		this.minVolum = minVolum; 
	}
	
	@Override
	public int minsteVolum() {
		return minVolum; 
	} 
	
	@Override
	public double pris() {
		return PRIS_PR_KUBIKK * minVolum; 
	}
	
	//toString metode 
	@Override
	public String toString() {
		return OPPDRAG_TYPE + super.toString(); 
	}
}