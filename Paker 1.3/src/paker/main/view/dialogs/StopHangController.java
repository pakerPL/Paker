package paker.main.view.dialogs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import paker.main.tools.ConnectDB;

public class StopHangController {

	
	@FXML private Label messange;
	@FXML private Button stopHang;
	@FXML private Button back;

	private Stage dialogStage;
	
	private String idkarnet, since;
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public void setIdKarnet(String idKarnet){
		this.idkarnet = idKarnet;
	}
	
	public void setSince(String since){
		this.since = since;
	}
	
	
	
	@FXML
	private void handleBack(){
		dialogStage.close();
	}
	
	@FXML
	private void handleStopHang(){
		PreparedStatement rs;
		try {
			System.out.println(idkarnet + " " + since);
			rs = ConnectDB.getIsnstance().getConn()
					.prepareStatement("SELECT public.zawiasy('"+idkarnet+"','"+since+"');");
			rs.executeUpdate();
			rs.close();
			ConnectDB.getIsnstance().setMssg("Zatrzymano zawieszenie");
			dialogStage.close();
			
		} catch (SQLException e1) {
			if(e1.getSQLState().equals("0100E")){
				ConnectDB.getIsnstance().setMssg("Zatrzymano zawieszenie");
				dialogStage.close();
			}else{
				ConnectDB.getIsnstance().setMssg("B³¹d z wstrzymywaniem zawieszenia");
				dialogStage.close();
			}

}
	}}
