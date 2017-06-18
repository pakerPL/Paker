package paker.main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import paker.main.PakerMain;

public class GroupOperateController {

private PakerMain main;
	
	@FXML
	private Label choiseGroupLabel;
	
	@FXML
	private Button submit;
	
	@FXML
	private Button create;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button deleteClient;
	
	@FXML
	private ComboBox changeGroup;
	
	@FXML
	private Button showClient;
	
	@FXML
	private Button exit;
	
	@FXML
	private void hangedExit(){
		main.showMainPanel();
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
}
