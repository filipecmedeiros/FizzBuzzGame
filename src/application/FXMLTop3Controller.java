package application;

import java.io.File;
import java.io.IOException;

import data.AbstractRepository;
import data.FizzBuzzRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.FizzBuzz;


public class FXMLTop3Controller {
	
	FizzBuzzRepository fbr;
	File fizzbuzzFile = new File("./fizzbuzz");
	
    @FXML
    private Label rankOne;

    @FXML
    private Label rankTwo;

    @FXML
    private Label rankThree;
	
    @FXML
    private Button buttonMenu;
	
	@FXML
	private void quitButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLButton.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
    
	@FXML
	public void initialize() {
		FizzBuzzRepository fbr = Main.getFBR();
		
		if (fizzbuzzFile.exists())
			fbr = (FizzBuzzRepository) FizzBuzzRepository.decode(fizzbuzzFile.getName());
		else
			fbr = new FizzBuzzRepository();	

		//Player number 1
		rankOne.setText(fbr.getRep().get(0).getPlayer()); 
		
		//Player number 2
		rankTwo.setText(fbr.getRep().get(1).getPlayer()); 
		
		//Player number 3
		rankThree.setText(fbr.getRep().get(2).getPlayer()); 
	
		
	}
}
