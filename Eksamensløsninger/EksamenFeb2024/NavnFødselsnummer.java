import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class NavnFødselsnummer extends Application {
	//Oppretter elementer som skal eksistere i hele applikasjonen 
	private Button btRegistrer = new Button("Registrer"); 
	private Label lblStatus = new Label("Oppgi navn og fødselsnummer"); 

	private TextField tfNavn = new TextField();
	private TextField tfFødNr = new TextField();
	private TextField tfEførst = new TextField();
	private TextField tfF = new TextField();
	private TextField tfM = new TextField();
	private TextField tfE = new TextField();
	private TextField tfFDato = new TextField();
	private TextField tfMåned = new TextField();
	private TextField tfÅr = new TextField();
	private TextField tfKjønn = new TextField();

	private BorderPane hovedPanel; 

	@Override
	public void start(Stage stage) throws Exception {
		hovedPanel = new BorderPane(); 

		hovedPanel.setTop(fyllInnPanel());  
		
		hovedPanel.setCenter(infoPanel()); 

		//legger til lytter på registrer knapp 
		btRegistrer.setOnAction(e -> regInfo());

		hovedPanel.setBottom(statusPanel()); 


		Scene scene = new Scene(hovedPanel, 300, 370); 
		stage.setScene(scene); 
		stage.setTitle("Test navn fødselsnummer"); 
		stage.show(); 
	}

	//metode som oppretter fyllinnPanel 
	public GridPane fyllInnPanel() {
		GridPane panel = new GridPane(); 
		//sentrerer elementer 
		panel.setPadding(new Insets(10)); 

		panel.add(new Label("Navn:"), 0, 0); 
		panel.add(tfNavn = new TextField(), 1, 0);
		panel.add(new Label("Fødselsnummer:") , 0, 1);
		panel.add(tfFødNr, 1, 1);
		panel.add(btRegistrer, 1, 2); 

		leggTilPynt(panel); 

		return panel; 
	}

	//metode som oppretter infoPanel
	public GridPane infoPanel() {
		GridPane panel = new GridPane(); 
		//sentrerer elementer 
		panel.setPadding(new Insets(10)); 

		panel.add(new Label("Etternavn først:") , 0, 0); 
		panel.add(tfEførst = new TextField(), 1, 0);
		panel.add(new Label("Fornavn:") , 0, 1);
		panel.add(tfF, 1, 1);
		panel.add(new Label("Mellomnavn:") , 0, 2); 
		panel.add(tfM = new TextField(), 1, 2);
		panel.add(new Label("Etternavn:") , 0, 3);
		panel.add(tfE, 1, 3);
		panel.add(new Label("Fødselsdato:") , 0, 4); 
		panel.add(tfFDato = new TextField(), 1, 4);
		panel.add(new Label("Måned:") , 0, 5);
		panel.add(tfMåned, 1, 5);
		panel.add(new Label("År:") , 0, 6); 
		panel.add(tfÅr = new TextField(), 1, 6);
		panel.add(new Label("Kjønn:") , 0, 7);
		panel.add(tfKjønn, 1, 7);

		leggTilPynt(panel); 

		return panel; 
	}

	//metode som lager status panel 
	public FlowPane statusPanel() {
		FlowPane panel = new FlowPane(); 

		panel.getChildren().add(lblStatus); 

		leggTilPynt(panel);

		return panel; 
	}
	
	//metode som fyller info 
	public void regInfo() {
		Navn navn = null; 
		Fødselsnummer fnr = null; 

		try {
			navn = new Navn(tfNavn.getText()); 
			fnr = new Fødselsnummer(tfFødNr.getText()); 
		} catch (Exception e){
			lblStatus.setText(e.toString()); 
		}

		//fyller info 
		if(navn != null) {
			tfEførst.setText(navn.etternavnFørst());
			tfF.setText(navn.getFornavn());
		    tfM.setText(navn.getMellomnavn());
			tfE.setText(navn.getEtternavn());
		}

		if(fnr != null) {
			tfFDato.setText(""+fnr.dato());
	        tfMåned.setText(""+fnr.måned()); 
			tfÅr.setText(""+fnr.år());
			//finner kjønn
			tfKjønn.setText(fnr.mann() ? "Mann" : "Kvinne");
		}
 
	}

	//metode som legger til border 
	public void leggTilPynt(Node panel) {
		panel.setStyle("-fx-background-color: #d3d3d3;" + 
			       "-fx-border-width: 2px;" + 
			       "-fx-padding: 10px;" + 
			       "-fx-border-color: green;");
	}
}