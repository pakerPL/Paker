package paker.main.view;

import java.util.Calendar;


import java.util.GregorianCalendar;
import javafx.event.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import paker.main.PakerMain;
import paker.main.tools.ConnectDB;

public class MainWindowController {
	
	@FXML
	private Label user;
	
	@FXML
	private Label message;
	
	@FXML
	private Label counter;
	
	@FXML
	private Label clock;
	
	private PakerMain main;
	
	private ConnectDB cdb;
	
	public MainWindowController() {
	}

	@FXML
	private void initialize(){
		timerOn();
		setMessage();
		cdb = new ConnectDB();
	}
	
	 private String pad(int fieldWidth, char padChar, String s) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = s.length(); i < fieldWidth; i++) {
		      sb.append(padChar);
		    }
		    sb.append(s);

		    return sb.toString();
		  }

	
	private void timerOn(){
	
		final Timeline digitalTime = new Timeline(new KeyFrame(Duration.seconds(0),
		        new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent actionEvent) {
	            Calendar calendar            = GregorianCalendar.getInstance();
	            String d = pad(2, '0', calendar.get(Calendar.DAY_OF_MONTH) + "");
	    		String m = pad(2, '0', (calendar.get(Calendar.MONTH) + 1) + "");
	    		String r = calendar.get(Calendar.YEAR)+"";
	            String hourString   = pad(2, '0', calendar.get(Calendar.HOUR_OF_DAY)   == 0 ? "12" : calendar.get(Calendar.HOUR_OF_DAY) + "");
	            String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
	            String secondString = pad(2, '0', calendar.get(Calendar.SECOND) + "");
	            clock.setText(d + "-" +m+ "-"+r+" "+hourString + ":" + minuteString + ":" + secondString);
	          }
	        }
	      ),
	new KeyFrame(Duration.seconds(1)));
		
		digitalTime.setCycleCount(Animation.INDEFINITE);
		
		 digitalTime.play();
	}
	
	private void setMessage(){
		final Timeline messanges = new Timeline(new KeyFrame(Duration.seconds(0),new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent actionEvent) {
				message.setText(ConnectDB.getIsnstance().getMssg());
		}}),new KeyFrame(Duration.seconds(1)));
		messanges.setCycleCount(Animation.INDEFINITE);
		messanges.play();
	}
	
	public void setPakerMain(PakerMain main){
		this.main = main;
	}
	
	public void setUser(String user){
		this.user.setText("Zalogowany jako: "+user);
	}
}
