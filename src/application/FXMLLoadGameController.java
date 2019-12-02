package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.FizzBuzz;

public class FXMLLoadGameController {
	
	@FXML
	public FizzBuzz game =  new FizzBuzz();
	
    @FXML
    private TextField textLoad;

    @FXML
    private Button buttonLoad;
	
    @FXML
    private Button buttonMenu;
    
	@FXML
	private void actionPlay(ActionEvent event) throws IOException {
		
		
		
		System.out.println("Carregado!");
		String dir= textLoad.getText();
		dir += ".fizzbuzz";
		game = FizzBuzz.decode(dir);
		loadGameButtonPushed(event);
		
	}
	
	@FXML
	private void loadGameButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLGame.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
	
	@FXML
	private void quitButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLButton.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
}
