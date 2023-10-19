package application;
	
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = FXMLLoader.load(getClass().getResource("/fxml/reloj.fxml"));
			Scene scene = new Scene(root,460,400);
			primaryStage.setForceIntegerRenderScale(false);
			primaryStage.setScene(scene);
			/* Cuando se cierra la primary stage la applicación dejará de funcionar */
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            @Override
	            public void handle(WindowEvent t) {
	                Platform.exit();
	                System.exit(0);
	            }
	        });
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
