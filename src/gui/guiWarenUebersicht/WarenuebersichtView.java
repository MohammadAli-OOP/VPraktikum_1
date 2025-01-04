package gui.guiWarenUebersicht;
   
import business.Tee;
import business.TeeModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WarenuebersichtView {
	
private WarenuebersichtControl
 	warenuebersichtControl;
private TeeModel teeModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeTees     
 		= new Label("Anzeige Tees");
    	private TextArea txtAnzeige  = new TextArea();
    	private Button btnAnzeigeTees = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public WarenuebersichtView(
 		WarenuebersichtControl 
 		warenuebersichtControl, 
   	 	Stage primaryStage, 
 		TeeModel teeModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige der Warenübersicht");
    		primaryStage.show();
    		this.warenuebersichtControl 
 			= warenuebersichtControl;
 		this.teeModel = teeModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeTees.setLayoutX(310);
    		lblAnzeigeTees.setLayoutY(40);
    		lblAnzeigeTees.setFont(font);
    		lblAnzeigeTees.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeTees);           
// Textbereich	
       		txtAnzeige.setEditable(false);
       		txtAnzeige.setLayoutX(310);
       		txtAnzeige.setLayoutY(90);
       		txtAnzeige.setPrefWidth(220);
       		txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige);        	
        	// Button
          	btnAnzeigeTees.setLayoutX(310);
        	btnAnzeigeTees.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeTees); 
   }
   
   private void initListener() {
	    btnAnzeigeTees.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeTeesAn();
	        	} 
   	    });
    }
   
    public void zeigeTeesAn(){
    	if(this.teeModel.getTee().size()>0){
       		StringBuffer text=new StringBuffer();
       		for (Tee tee2 : this.teeModel.getTee()) {
    			text.append(tee2.gibTeeZurueck(' '));
    		}
       		
       		txtAnzeige.setText(text.toString());
       	}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Tee aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
