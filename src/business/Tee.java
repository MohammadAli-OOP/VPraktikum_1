package business;

import java.util.ArrayList;

public class Tee {
	
	// artikelnummer des Teees
    private String artikelnummer;
    // Infos
    private float bezeichnung;
    private float kategorie;
    // KOffin des Teees
    private String koffin;
    // krauter des Tees
    private ArrayList<String> krauter;

    public Tee(String artikelnummer, float bezeichnung, float kategorie,
    	String koffin, String[] krauter){
    	if(krauter==null) {
    		throw new IllegalArgumentException();
    	}
   		this.artikelnummer = artikelnummer;
  	    this.bezeichnung = bezeichnung;
   	    this.kategorie = kategorie;
   	    this.koffin = koffin;
   	    setKrauterAusAray(krauter);
    }
    private void setKrauterAusAray(String [] krauter) {
    	this.krauter=new ArrayList<String>();
    	for (int i = 0; i < krauter.length; i++) {
			this.krauter.add(krauter[i]);
			
		}
    }
    
	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setartikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(float bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public float getKategorie() {
		return kategorie;
	}

	public void setKategorie(float kategorie) {
		this.kategorie = kategorie;
	}

	public String getKoffin() {
		return koffin;
	}

	public void setKoffin(String koffin) {
		this.koffin = koffin;
	}

	public ArrayList<String> getKrauter() {
		return krauter;
	}

	public void setKrauter(String[] krauter) {
		setKrauterAusAray(krauter);
	}
	
	public String getkrauterAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getKrauter().size() - 1; i++) {
			ergebnis = ergebnis + this.getKrauter().get(i) + trenner; 
		}
		return ergebnis	+ this.getKrauter().get(i);
	}
	
	public String gibTeeZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getBezeichnung() + trenner
  		    + this.getKategorie() + trenner
  		    + this.getKoffin() + trenner 
  		    + this.getkrauterAlsString(trenner) + "\n";
  	}
}

