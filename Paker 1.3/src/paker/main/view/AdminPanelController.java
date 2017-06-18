package paker.main.view;

import component.view.MDataChooser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import paker.main.PakerMain;

public class AdminPanelController {

	// =========TAB1 Statystyki ogólne============== //
	
	@FXML private Tab allStats;
	
	@FXML private Label od;
	
	@FXML private Label to;
	
	@FXML private MDataChooser dateFromAllStats;
	
	@FXML private MDataChooser dateToAllStats;
	
	@FXML private Button thisWeek;
	
	@FXML private Button thisMonth;
	
	@FXML private Button fromBegin;
	
	@FXML private Button ownDate;
	
	@FXML private Button savePDF;
	
	@FXML private Button backAllStats;
	
	@FXML private TableView<Object> showStats;
	
	//==============TAB 2 Statystyki pracowników ==============//
	
	@FXML private Tab userStats;
	
	@FXML private Label getWorkerLabel;
	
	@FXML private ChoiceBox<Object> getWorker;
	
	@FXML private CheckBox dateFilterUserStats;
	
	@FXML private Button showUserStats;
	
	@FXML private MDataChooser dateFromUserStats;
	
	@FXML private MDataChooser dateToUserStats;
	
	@FXML private Button backUserStast;
	
	//=============TAB 3 Statystyki odwiedzin ===============//
	
	@FXML private Tab visitStats;
	
	@FXML private CheckBox nameFilter;
	
	@FXML private CheckBox dateFilterVisitStats;
	
	@FXML private CheckBox keyFilter;
	
	@FXML private TextField name;
	
	@FXML private TextField keyNumber;
	
	@FXML private MDataChooser dateFromVisitStats;
	
	@FXML private MDataChooser dateToVisitStats;
	
	@FXML private Button showVisitStats;
	
	@FXML private Button backVisitStats;
	
	//=============TAB 4 Ustawienia ==========================//
	
	@FXML private Tab settings;
	
	@FXML private ChoiceBox<Object> getCustomer;
	
	@FXML private ChoiceBox<Object> getUser;
	
	private ToggleGroup kindPrice = new ToggleGroup();
	
	@FXML private RadioButton oneTimePrice;
	
	@FXML private RadioButton typesPrice;
	
	@FXML private ChoiceBox<Object> getOneTime;
	
	@FXML private ChoiceBox<Object> getType;
	
	@FXML private Label choiceTypeLabel;
	
	@FXML private Label enterPriceLabel;
	
	@FXML private TextField putOneTimePrice;
	
	@FXML private TextField putTypesOneTime;
	
	@FXML private Button deletaCustomer;
	
	@FXML private Button newUser;
	
	@FXML private Button editUser;
	
	@FXML private Button lockUser;
	
	@FXML private Button addOneTime;
	
	@FXML private Button configure;
	
	@FXML private Button backSettings;
	
	@FXML
	private void handleBack(){
		main.showMainPanel();
	}
	
	@FXML
	private void initialize(){
		oneTimePrice.setToggleGroup(kindPrice);
		typesPrice.setToggleGroup(kindPrice);
	}
	
	private PakerMain main;
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
}
