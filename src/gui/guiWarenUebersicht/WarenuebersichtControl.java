package gui.guiWarenUebersicht;
import business.TeeModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class WarenuebersichtControl implements Observer{	
	private WarenuebersichtView warenuebersichtView;
	private TeeModel teeModel;
	public WarenuebersichtControl(Stage primaryStage){
 		this.teeModel = TeeModel.getInstanz(); 		
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			teeModel);
		
		this.teeModel.addObserver(this);
	}
	@Override
	public void update() {
		this.warenuebersichtView.zeigeTeesAn();
		
	}
}

