package gui.guiTeeladen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Tee;
import business.TeeModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class TeeControl implements Observer{
	private TeeModel teeModel;
	private TeeView teeView;
	
	public TeeControl(Stage primaryStage) {
		super();
		this.teeModel=TeeModel.getInstanz();
		this.teeView=new TeeView(this, teeModel, primaryStage);
		
		this.teeModel.addObserver(this);
	}
    public void nehmeTeeAuf(){
    	try{
    		teeModel.addTee( new Tee(
        			this.teeView.getTxtArtikelnummer().getText(), 
       	            Float.parseFloat(this.teeView.getTxtBezeichnung().getText()),
       	            Float.parseFloat(this.teeView.getTxtKategorie().getText()),
       	         this.teeView.getTxtKoffin().getText(),
       	         this.teeView.getTxtKrauter().getText().split(";")));
    		this.teeView.zeigeInformationsfensterAn("Der Tee wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		this.teeView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    
    public void leseAusDatei(String typ){
    	try {
      		this.teeModel.leseAusDatei(typ);
      	}
		catch(IOException exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			//this.teeView.zeigeFehlermeldungsfensterAn(
			//	"Unbekannter Fehler beim Lesen!"+ exc.getMessage());
	        //exc.printStackTrace();  // Detaillierte Ausgabe des Fehlers in der Konsole
		}
		teeModel.notifyObserver();

	}
	public void schreibeTeeInCsvDatei() {
		try {
			this.teeModel.schreibeTeeInCsvDatei();
   			this.teeView.zeigeInformationsfensterAn(
	   			"Die Tee wurden gespeichert!");
		}	
		catch(IOException exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
		teeModel.notifyObserver();
	}
	@Override
	public void update() {
		this.teeView.zeigeTeeAn();
	}
	
	
}
