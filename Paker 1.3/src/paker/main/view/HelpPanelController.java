package paker.main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import paker.main.PakerMain;

public class HelpPanelController {

	@FXML
	private TextArea infoArea;
	
	@FXML 
	private Button back;
	
	@FXML
	private void handleBack(){
		main.showMainPanel();
	}
	
	private PakerMain main;
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
}
