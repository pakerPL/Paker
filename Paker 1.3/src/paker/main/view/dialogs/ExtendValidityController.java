package paker.main.view.dialogs;

import component.view.MDataChooser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExtendValidityController {

	@FXML private CheckBox checkValidity;
	
	@FXML private Label startDateLabel;
	
	@FXML private MDataChooser startDate;
	
	@FXML private Label groupLabel;
	
	@FXML private ChoiceBox<Object> group;
	
	@FXML private Label typeLabel;
	
	@FXML private ChoiceBox<Object> type;
	
	@FXML private Label cutPriceLabel;
	
	@FXML private TextField cutPrice;
	
	@FXML private Button validity;
	
	@FXML private Button back;
	
	private Stage dialogStage;
	
	private String id, data, grupaName, typeName;
	private int prac, kli, typ, grupa;
	
	public void setDialogStage(Stage dialogStage, String id, String data, int grupa, int typ,String grupaName, String typeName, int kli, int prac) {
        this.dialogStage = dialogStage;
        this.prac = prac;
		this.id = id;
		this.kli = kli;
		this.data = data;
		this.grupa = grupa;
		this.typ = typ;
		this.grupaName = grupaName;
		this.typeName = typeName;
		
		group.getItems().add(grupa + "." + grupaName);
		group.getSelectionModel().select(0);
		type.getItems().add(typ+"."+typeName);
		type.getSelectionModel().select(0);
    }
	
	@FXML
	private void handleBack(){
		dialogStage.close();
	}
	
}
