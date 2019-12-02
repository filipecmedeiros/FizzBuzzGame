package application;
	
import java.io.File;
import java.io.IOException;

import data.FizzBuzzRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.FizzBuzz;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Main extends Application {

	
	public static FizzBuzz game;
	
	public static FizzBuzzRepository fbr;
	
	public static FizzBuzz getGame() {
		return game;
	}
	
	public static void setGame(FizzBuzz newGame) {
		game = newGame;
	}
	
	public static FizzBuzzRepository getFBR() {
		return fbr;
	}
	
	public void start(Stage stage) throws IOException {
	
		//BackEnd
		File fizzbuzzFile = new File("./fizzbuzz");
		
		if (fizzbuzzFile.exists())
			fbr = (FizzBuzzRepository) FizzBuzzRepository.decode(fizzbuzzFile.getName());
		else
			fbr = new FizzBuzzRepository();
		
		//FrontEnd		
		Parent root = FXMLLoader.load(getClass().getResource("FXMLButton.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


