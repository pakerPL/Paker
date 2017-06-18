package paker.main.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paker.main.PakerMain;
import paker.main.tools.ConnectDB;
import paker.main.tools.LogInOut;
import paker.main.tools.PassInBaseDB;
import paker.main.view.dialogs.ExtendValidityController;
import paker.main.view.dialogs.StopHangController;

public class MainPanelController {
	
	final ToggleGroup groupCloakroom = new ToggleGroup();
	
	@FXML
	private Button info;
	
	@FXML
	private Button exit;
	
	@FXML
	private Button menagePass;
	
	@FXML
	private Button oneTime;
	
	@FXML
	private Button groupOperate;
	
	@FXML
	private Button admin;
	
	@FXML
	private Label numberPassLabel;
	
	@FXML
	private TextField numberPass;
	
	@FXML
	private Button okButton;
	
	@FXML
	private Label keyNumberMen;
	
	@FXML
	private Label keyNumberWomen;
	
	@FXML
	private Label putKeyNumberLabel;
	
	@FXML
	private TextField putKeyNumber;
	
	@FXML
	private Button exitClient;
	
	@FXML
	private RadioButton men;
	
	@FXML
	private RadioButton woMen;
	
	
	private byte command;
	
	private PakerMain main;
	
	@FXML
	private void initialize(){
		men.setToggleGroup(groupCloakroom);
		woMen.setToggleGroup(groupCloakroom);
	}
	
	@FXML
	private void handleAdminPanel(){
		main.adminPanel();
	}
	
	@FXML
	private void handleInfo(){
		main.helpPanel();
	}
	
	@FXML
	private void handleOkButton(){
		PassInBaseDB pibdb = new PassInBaseDB(ConnectDB.getIsnstance().getConn(), numberPass.getText());
		if (pibdb.getData(0) == null){
			ConnectDB.getIsnstance().setMssg("Brak karnetu w bazie");
		}else if (pibdb.isHang()){
			ConnectDB.getIsnstance().setMssg("Karnet zawieszony");
	         try {
				FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(PakerMain.class.getResource("view/dialogs/StopHang.fxml"));
		        AnchorPane dialogInUse = (AnchorPane) loader.load();
		        
		         Stage dialogStage = new Stage();
		         dialogStage.setTitle("Zawieszony karnet");
		         dialogStage.initModality(Modality.WINDOW_MODAL);
		         Scene scene = new Scene(dialogInUse);
		         dialogStage.initOwner(main.getPrimaryStage());
		         dialogStage.setScene(scene);
		         dialogStage.setResizable(false);
		         dialogStage.setAlwaysOnTop(true);
		         
		         StopHangController controller = loader.getController();
		         controller.setDialogStage(dialogStage);
		         
		         controller.setIdKarnet(pibdb.getData(4));
		         controller.setSince(pibdb.getData(5));
		         
		         dialogStage.showAndWait();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (!pibdb.isHang()){
			if(pibdb.getData(8).equals("f")) {
				ConnectDB.getIsnstance().setMssg("Karnet nieaktywny");
				 try {
						FXMLLoader loader = new FXMLLoader();
				        loader.setLocation(PakerMain.class.getResource("view/dialogs/ExtendValidity.fxml"));
				        AnchorPane dialogInUse = (AnchorPane) loader.load();
				        
				         Stage dialogStage = new Stage();
				         dialogStage.setTitle("Karnet "+numberPass.getText()+" nie aktywny");
				         dialogStage.initModality(Modality.WINDOW_MODAL);
				         Scene scene = new Scene(dialogInUse);
				         dialogStage.initOwner(main.getPrimaryStage());
				         dialogStage.setScene(scene);
				         dialogStage.setResizable(false);
				         dialogStage.setAlwaysOnTop(true);
				         
				         ExtendValidityController controller = loader.getController();
				         controller.setDialogStage(dialogStage, pibdb.getData(4), pibdb.getData(5), pibdb.getIdGrupa(), pibdb.getIdType(), pibdb.getData(10), pibdb.getData(11), Integer.parseInt(pibdb.getData(16)), LogInOut.getInstance().getUserID());
				         
				         
				         dialogStage.showAndWait();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} else {
				
			}
		}
		//main.passInBasePanel();
	}
	
	@FXML
	private void handleGroupOperate(){
		main.groupOperatePanel();
	}
	
	@FXML
	private void handleMenage(){
		main.menagePassPanel();
	}
	
	@FXML
	private void handleOneTime(){
		main.oneTimePanel();
	}
	
	@FXML
	private void handleExit(){
		LogInOut.getInstance().LogOut();
		System.exit(0);
	}
	
	public int getCommand(){
		return this.command;
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
}
