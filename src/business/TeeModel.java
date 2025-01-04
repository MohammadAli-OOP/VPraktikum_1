package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import factory.ConcreteCreator;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeeModel implements Observable {
	private ArrayList<Tee> tee=new ArrayList<Tee>();
	private static TeeModel instanz;
	private Vector<Observer> observers=new Vector<Observer>();
	
	
	private TeeModel() {
	}
	
	public static TeeModel getInstanz() {
		if(instanz==null) {
			instanz=new TeeModel();
		}
		return instanz;
	}

	public ArrayList<Tee> getTee() {
		return tee;
	}

	public void addTee(Tee tee) {
		this.tee.add(tee);
	}

	public void schreibeTeeInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeeAusgabe.csv"));
			for (Tee tee2 : this.tee) {
				aus.write(tee2.gibTeeZurueck(';'));
			}
			
			aus.close();
	}
	
	public void leseAusDatei(String typ) throws IOException{
      		
		Creator creator=new ConcreteCreator();
		Product reader=creator.factoryMethod(typ);
		
		String [] zeile= reader.leseAusDatei();
		
		
		
		this.tee.add(new Tee(zeile[0], 
				Float.parseFloat(zeile[1]), 
				Float.parseFloat(zeile[2]), 
				zeile[3], zeile[4].split("_")));
		
		reader.schliesseDatei();
		notifyObserver();
		
//		if("csv".equals(typ)){
//      			BufferedReader ein = new BufferedReader(new FileReader("TeeAusgabe.csv"));
//      			String[] zeile = ein.readLine().split(";");
//      			this.tee = new Tee(zeile[0], 
//      				Float.parseFloat(zeile[1]), 
//      				Float.parseFloat(zeile[2]), 
//      				zeile[3], zeile[4].split(";"));
//      			
//      				ein.close();
//      		}
      }

	@Override
	public void addObserver(Observer obs) {
		observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.removeElement(obs);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			observers.elementAt(i).update();
			
		}
		
	}		
}
