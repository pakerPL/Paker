package paker.main;

import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import paker.main.view.*;

public class PakerMain extends Application{
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private String userLogIn = null;
	
	
	@Override
    public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PAKER 1.3 FX");
		this.primaryStage.setFullScreen(true);
		
		showLogDialog();
		initRootLayout();
		showMainPanel();
		
	}
	
	public void initRootLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PakerMain.class.getResource("view/MainWindow2.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			MainWindowController mainWindow = loader.getController();
			mainWindow.setPakerMain(this);
			mainWindow.setUser(userLogIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void menagePassPanel(){
         try {
        	 rootLayout.setCenter(null);
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(PakerMain.class.getResource("view/MenagePass.fxml"));
			 AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 MenagePassController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void oneTimePanel(){
        try {
       	 rootLayout.setCenter(null);
       	 FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/OneTime.fxml"));
			 AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 OneTimeController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adminPanel(){
        try {
       	 rootLayout.setCenter(null);
       	 FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/AdminPanel.fxml"));
			 AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 AdminPanelController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void groupOperatePanel(){
        try {
       	 rootLayout.setCenter(null);
       	 FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/GroupOperate.fxml"));
			 AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 GroupOperateController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void passInBasePanel(){
        try {
        	rootLayout.setCenter(null);
       	 	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/PassInBase.fxml"));
			AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 PassInBaseController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void helpPanel(){
        try {
        	rootLayout.setCenter(null);
       	 	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/HelpPanel.fxml"));
			AnchorPane panelInUse = (AnchorPane) loader.load();
			
			 rootLayout.setCenter(panelInUse);
			 
			 HelpPanelController controller = loader.getController();
			 controller.setPakerMain(this);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMainPanel() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PakerMain.class.getResource("view/MainPanel.fxml"));
            AnchorPane panelInUse = (AnchorPane) loader.load();
            
            rootLayout.setCenter(panelInUse);
            
            MainPanelController controller = loader.getController();
            controller.setPakerMain(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showLogDialog(){
		try { 
		 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(PakerMain.class.getResource("view/LogInDialog.fxml"));
         AnchorPane dialogInUse = (AnchorPane) loader.load();
         
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Zaloguj siê");
         dialogStage.initModality(Modality.WINDOW_MODAL);
         dialogStage.initStyle(StageStyle.UNDECORATED);
         dialogStage.initOwner(primaryStage);
         Scene scene = new Scene(dialogInUse);
         dialogStage.setScene(scene);
         dialogStage.setResizable(false);
         dialogStage.setAlwaysOnTop(true);
         
         LogInDialogController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         
         dialogStage.showAndWait();
         userLogIn = controller.getUserLogin();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	
	public static void main(String[] args) {
        launch(args);
    }
	
}
