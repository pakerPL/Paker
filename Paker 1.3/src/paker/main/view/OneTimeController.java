package paker.main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import paker.main.PakerMain;

public class OneTimeController {

	private PakerMain main;
	
	final ToggleGroup groupCloakroom = new ToggleGroup();
	
	@FXML
	private Label nameClientLabel;
	
	@FXML
	private TextField nameClient;
	
	@FXML
	private Label choiseClientLabel;
	
	@FXML
	private ComboBox choiseClient;
	
	@FXML
	private Button newClient;
	
	@FXML
	private Button editClient;
	
	@FXML
	private Button showClient;
	
	@FXML
	private Label keyNumberLabel;
	
	@FXML
	private TextField keyNumber;
	
	@FXML
	private RadioButton cloakroomMen;
	
	@FXML
	private RadioButton cloakroomWomen;
	
	@FXML
	private Label enterInLabel;
	
	@FXML
	private ComboBox enterIn;
	
	@FXML
	private CheckBox outsidePass;
	
	@FXML
	private Button enter;
	
	@FXML
	private Button exit;
	
	@FXML
	private void hangedExit(){
		main.showMainPanel();
	}
	
	@FXML
	private void initialize(){
		cloakroomMen.setToggleGroup(groupCloakroom);
		cloakroomWomen.setToggleGroup(groupCloakroom);
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
}
