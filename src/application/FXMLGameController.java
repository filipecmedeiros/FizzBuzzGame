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
import javafx.stage.Stage;
import model.FizzBuzz;
import data.FizzBuzzRepository;

public class FXMLGameController {
	
	int num;
	public FizzBuzz game;

	public FizzBuzzRepository fbr;
	public File fizzbuzzFile = new File("./fizzbuzz");
	

    @FXML
    private Button buttonFizz;

    @FXML
    private Button buttonFizzBuzz;

    @FXML
    private Button buttonBuzz;

    @FXML
    private Button buttonNum;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonQuit;
    
    @FXML
    private Label numberQuestion;
    
    @FXML
    private Label pontoLabel;
    
    
    @FXML
    private void showNumberLabel() {
    	num = game.showNumber();	
    	System.out.println(num);
    	numberQuestion.setText(Integer.toString(num)); 
	}
    
    @FXML
    private void playButtonBuzz(ActionEvent event) throws IOException {
    	int ponto;
    	ponto = game.play("buzz");
    	if(ponto > 0) {
    		game.setPoints(game.getPoints() + ponto);
    	}else {
			fbr.create(game);
			fbr.save(fizzbuzzFile.getName());
    		gameOverPushed(event);
    	}
    	showNumberLabel();
    	pontoLabel.setText(Integer.toString(game.getPoints())); 
    }
    
   
    @FXML
    private void playButtonFizz(ActionEvent event) throws IOException {
    	int ponto;
    	ponto = game.play("fizz");
    	System.out.println(ponto);
    	if(ponto > 0) {
    		game.setPoints(game.getPoints() + ponto);
    	}else {
    		fbr.create(game);
			fbr.save(fizzbuzzFile.getName());
    		gameOverPushed(event);
    	}
    	showNumberLabel();
    	pontoLabel.setText(Integer.toString(game.getPoints())); 
    }
    
    @FXML
    private void playButtonFizzBuzz(ActionEvent event) throws IOException {
    	
    	int ponto;
    	ponto = game.play("fizzbuzz");
    	System.out.println(ponto);
    	if(ponto > 0) {
    		game.setPoints(game.getPoints() + ponto);
    	}else {
    		fbr.create(game);
			fbr.save(fizzbuzzFile.getName());
    		gameOverPushed(event);
    	}
    	showNumberLabel();
    	pontoLabel.setText(Integer.toString(game.getPoints())); 
    }
    
    @FXML
    private void playButtonNum(ActionEvent event) throws IOException {
    	
    	int ponto;
    	ponto = game.play("");
    	System.out.println(ponto);
    	if(ponto > 0) {
    		game.setPoints(game.getPoints() + ponto);
    	}else {
    		fbr.create(game);
			fbr.save(fizzbuzzFile.getName());
    		gameOverPushed(event);
    	}
    	showNumberLabel();
    	pontoLabel.setText(Integer.toString(game.getPoints())); 
    }
    
    @FXML
    private void saveGame(ActionEvent event) {
    	String nome = Main.getGame().getPlayer();
    	game.saveGame(nome);
    	System.out.println("Jogo Salvo!");
    }
    
	@FXML
	private void gameOverPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLGameOver.fxml"));
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
	
	@FXML
	public void initialize() {
		
		game =  Main.getGame();		 
		fbr = Main.getFBR();
		
		showNumberLabel(); 
	}
}
