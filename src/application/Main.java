package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {

	static Stage pstage;
	static Connection con;
	
	@Override
	public void start(Stage primaryStage) {
		pstage=primaryStage;
		changeScene("Start screen.fxml","Start Screen",759,483);
	}
	
	public void changeScene(String gui,String title,int width,int height) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource(gui));
			Scene scene = new Scene(root,width,height);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			pstage.setScene(scene);
			pstage.setTitle(title);
			pstage.setResizable(false);
			pstage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void connectDB(String url,String user,String pass) throws SQLException{
		con=DriverManager.getConnection(url, user, pass);
		System.out.println(con);
		}
	
	public static void main(String[] args) throws SQLException {
		connectDB("jdbc:mysql://localhost:3306/?user=root","root","root");
		launch(args);  //Starting GUI
	}
}
