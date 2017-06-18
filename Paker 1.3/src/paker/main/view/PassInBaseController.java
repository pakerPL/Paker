package paker.main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import paker.main.PakerMain;
import paker.main.tools.LogInOut;

public class PassInBaseController {

	private PakerMain main;
	
	@FXML private Button back;
	
	
	
	@FXML
	private void handleBack(){
		main.showMainPanel();
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
	
}
