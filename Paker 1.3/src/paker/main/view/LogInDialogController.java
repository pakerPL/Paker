package paker.main.view;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paker.main.tools.ConnectDB;
import paker.main.tools.LogInOut;

public class LogInDialogController {

	@FXML
	private Label message;
	
	@FXML
	private TextField login;
	
	@FXML
	private TextField pass;
	
	@FXML
	private Button ok;
	
	@FXML
	private Button exit;
	
	@FXML
	private void handleExit(){
		System.exit(0);
	}
	
	private Stage dialogStage;
	
	@FXML
	private void handleOK(){
		LogInOut lio = LogInOut.getInstance();
		lio.initLogInOut(ConnectDB.getIsnstance().getConn(), login.getText(), getPass());
		byte flag = lio.LogIn();
		if (flag == 1) {
			message.setText("U¿ytkownik ju¿ zalogowany");
		} else if (flag == 3) {
			message.setText("B³êdny login i/lub has³o");
		} else if (flag == 4) {
			message.setText("U¿ytkownik zablokowany");
		} else if (flag == 2) {
		dialogStage.close();
		}
	}
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	private String characterToString(char[] znaki){
		String bufor = Character.toString(znaki[0]);
		for(int i=1; i<znaki.length; i++){
			bufor = bufor.concat(Character.toString(znaki[i]));
		}		
		return bufor;
	}


	private String getPass(){
		String pass;
		pass = characterToString(this.pass.getText().toCharArray());
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			pass = hash.toString(16);
			return pass;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String getUserLogin(){
		return(login.getText());
	}
}
