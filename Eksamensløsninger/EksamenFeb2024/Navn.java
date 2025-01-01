public class Navn implements Comparable<Navn>{
	protected String fornavn; 
	protected String etternavn; 
	protected String mellomnavn; 

	//konstruktørmetoder 
	public Navn(String fornavn, String mellomnavn, String etternavn) {
		setFornavn(fornavn); 
		setMellomnavn(mellomnavn); 
		setEtternavn(etternavn); 
	}

	public Navn(String fornavn, String etternavn) {
		this(fornavn, null, etternavn);
	}

	public Navn(String navn) {
		//splitter navn ved mellomrom og lager nytt navn objekt. 
		String[] navnTab = navn.split(" "); 

		if(navn.length() < 2) {
			throw new IllegalArgumentException("Mangler fornavn/etternavn!");
		}
		//setter fornavn og mellomnavn først 
		setFornavn(navnTab[0]); 
		setEtternavn(navnTab[navnTab.length-1]); 
		
		//deretter sjekker om mellomnavn eksisterer og setter evt. 
		if(navnTab.length > 2){
			String mellomnavn = navn.substring(fornavn.length()+1, 
				navn.length()-etternavn.length()-1); 
			setMellomnavn(mellomnavn); 
		}
	}

	//metode for å sjekke om fornavn er lovlig og sette den 
	public void setFornavn(String fNavn) {
		//sjekker om det kun er - eller bokstav 
		if(!fNavn.matches("[\\w-]+")) {
			throw new IllegalArgumentException("Ulovlig tegn i fornavn: " + fNavn); 
		}
		fornavn = fNavn; 
	}

	public String getFornavn() {
		return fornavn; 
	}


	//metode for å sjekkke om etternavn er lovlig og sette den
	public void setEtternavn(String eNavn) {
		//sjekker om det kun er - eller bokstav 
		if(!eNavn.matches("[\\w-]+")) {
			throw new IllegalArgumentException("Ulovlig tegn i etternavn: " + eNavn); 
		}
		etternavn = eNavn; 
	}

	public String getEtternavn() {
		return etternavn; 
	}

	//metode for å sjekke at mellomnavn er lovlig og sette den 
	public void setMellomnavn(String mNavn) {
		//sjekker om den er tom eller lik null og avslutter
		if(mNavn == null || mNavn.length() == 0) return; 
		//sjekker om det kun er -, " " eller bokstav 
		if(!mNavn.matches("[\\w- ]+")) {
			throw new IllegalArgumentException("Ulovlig tegn i mellomnavn: " + mNavn); 
		}
		mellomnavn = mNavn; 
	}

	public String getMellomnavn() {
		return mellomnavn; 
	}


	//tString metode 
	public String toString () {
		return fornavn+" "+mellomnavn+" "+etternavn;  
	}

	//metode for etternavn først 
	public String etternavnFørst () {
		return etternavn+", "+fornavn+" "+((mellomnavn != null)? mellomnavn : "");  
	}

	//compare to metode 
	public int compareTo(Navn n) {
		return etternavnFørst().compareTo(n.etternavnFørst()); 
	}


}