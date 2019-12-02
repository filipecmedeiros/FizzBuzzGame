package application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Node;


public class FXMLButtonController implements Initializable{


    @FXML
    private Button novoJogo;

    @FXML
    private Button button1;

    @FXML
    private Button button;

    @FXML
    private TextField txtNome;

    @FXML
    private Label labelOlaMundo;

	
	@FXML
	private void actionButton(ActionEvent event) {
  		System.out.println("Voce clicou...!");
		labelOlaMundo.setText("Ola Mundo: "+txtNome.getText());
	}
	
    @FXML
    private Button carregarJogo;
	
	@FXML
	private void newGameButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLNewGame.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
	
	@FXML
	private void loadGameButtonPushed(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLLoadGame.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
	
	@FXML
	private void rankingGameButton(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLTop3.fxml"));
		Scene tableViewSceme = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewSceme);
		window.show();
	}
	
	@FXML
	private void actionQuitGame(ActionEvent event) {
		Stage stage = (Stage) button.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
}

