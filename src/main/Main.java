package main;
import gui.guiTeeladen.TeeControl;
import gui.guiWarenUebersicht.WarenuebersichtControl;
//--module-path C:\Users\mehma\Desktop\javafx-sdk-22.0.1\lib --add-modules=javafx.controls,javafx.fxml
//import gui.BuergeraemterAnwendersystem;
//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
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeeControl(primaryStage);
		
		Stage fensterWarenuebersicht=new Stage();
		new WarenuebersichtControl(fensterWarenuebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
	
}
