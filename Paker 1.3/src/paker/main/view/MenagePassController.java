package paker.main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import paker.main.PakerMain;

public class MenagePassController {

	private PakerMain main;
	
	@FXML
	private CheckBox checkFilter;
	
	@FXML
	private Button filter;
	
	@FXML
	private CheckBox activePass;
	
	@FXML
	private Button createPass;
	
	@FXML
	private ComboBox chooseGroup;
	
	@FXML
	private ComboBox chooseType;
	
	@FXML
	private Label chooseGroupLabel;
	
	@FXML
	private Label chooseTypeLabel;
	
	@FXML
	private CheckBox passNumberNameFilter;
	
	@FXML
	private TextField passNumberName;
	
	@FXML
	private Button extend;
	
	@FXML
	private Button edit;
	
	@FXML
	private Button hang;
	
	@FXML
	private CheckBox onlyHangedPassFilter;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button exit;
	
	@FXML
	private Label amountRecords;
	
	@FXML
	private Label sum;
	
	@FXML
	private void hangedExit(){
		main.showMainPanel();
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
	
}
