package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.FizzBuzzRepository;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.FizzBuzz;
import javafx.fxml.Initializable;


public class FXMLNewGameController implements Initializable{
	
	FizzBuzzRepository fbr;
	File fizzbuzzFile = new File("./fizzbuzz");
	
    @FXML
    private TextField nomeUs;

    @FXML
    private Label labelNome;

    @FXML
    private Button buttonEnter;
    
    @FXML
    FizzBuzz game;
	
	@FXML
	public void actionPlay(ActionEvent event) throws IOException {
		
		System.out.println("Imprimido!");
		String player = nomeUs.getText();
		game = new FizzBuzz (player);
		Main.setGame(game);
		fbr.create(game);
		fbr.save(fizzbuzzFile.getName());		
		newGameButtonPushed(event);

	}
	
	@FXML
	public void newGameButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLGame.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}

	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
		if (fizzbuzzFile.exists())
			fbr = (FizzBuzzRepository) FizzBuzzRepository.decode(fizzbuzzFile.getName());
		else
			fbr = new FizzBuzzRepository();	
		
	}

}
