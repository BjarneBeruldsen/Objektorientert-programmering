//Oppgave 2 Eksamensapplikasjon
//RadioButtons og ToggleGroup
//Button og EventHandler
//BorderPane, FlowPane, GridPane, HBox

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
public class EksamensApplikasjon extends Application {
	ToggleGroup gruppe = new ToggleGroup(); 
	private RadioButton rbJa = new RadioButton("Ja"); 
	private RadioButton rbNei = new RadioButton("Nei"); 
	
	
	private Button btFørste, btForrige, btNeste, btSiste, btLevere; 
	
	private BorderPane hovedPanel; 
	
	//lager oppgave her 
	JaNeiOppgave oppg = new JaNeiOppgave("Er Oslo hovedstaden i Norge?", 5.0, "true"); 
	
	@Override
	public void start(Stage stage) throws Exception {
		//oppretter hovedpanelet 
		hovedPanel = new BorderPane(); 
		
		hovedPanel.setTop(OverskriftsPanel()); 
		
		hovedPanel.setCenter(SpørsmålsPanel()); 
		
		hovedPanel.setBottom(KnappePanel()); 
		
		btLevere.setOnAction(e -> sjekkSvar()); 
		
		Scene scene = new Scene(hovedPanel, 400, 300); 
		stage.setScene(scene); 
		stage.setTitle("Eksamensoppgaver"); 
		stage.show(); 
	}
	
	//metode som oppretter overksriftspanel 
	public FlowPane OverskriftsPanel() {
		FlowPane panel = new FlowPane(); 
		
		Text overskrift = new Text("Eksamensoppgaver"); 
		//lager font og antar at den er bold med størrelse ca.24
		overskrift.setFont(Font.font("Times New Roman", 
																	FontWeight.BOLD, 24)); 
		
		//legger elementer til panelet 
		panel.getChildren().add(overskrift); 
		
		return panel; 
	}
	
	//metode som oppretter spørsmålpanel 
	public GridPane SpørsmålsPanel() {
		GridPane panel = new GridPane(); 
		
		panel.setPadding(new Insets(10)); 
		
		panel.add(new Label(""+oppg.getSpørsmål()), 0, 0); 
		panel.add(rbJa, 0, 1); 
		panel.add(rbNei, 0, 2); 

		rbJa.setToggleGroup(gruppe); 
		rbNei.setToggleGroup(gruppe); 
		
		//legger til kant 
		panel.setStyle("-fx-background-color: #d3d3d3; " +
										"-fx-border-width: 2px; " + 
										"-fx-border-color: black"); 
		return panel; 
	}
	
	//metode som oppretter knappepanel 
	public HBox KnappePanel() {
		HBox panel = new HBox(); 
	
		panel.setSpacing(10); 
		panel.setAlignment(Pos.CENTER); 
	
		//Oppretter knapper og legger til panelet 
		btFørste = new Button("<< Første"); 
		btForrige = new Button("< Forrige"); 
		btNeste = new Button("Neste >"); 
		btSiste = new Button("Siste >>"); 
		btLevere = new Button("LEVERE!"); 
		
		panel.getChildren().addAll(btFørste, btForrige, btNeste, 
															btSiste, btLevere); 
															
		return panel; 
	}
	
	//metode for å sjekke svar 
	public void sjekkSvar() {
		String svar = ""; 
		if(rbNei.isSelected()) {
			svar = "false"; 
		}
		else if(rbJa.isSelected()) {
			svar = "true";
		}
		
		if(oppg.score(svar) == 1.0) {
			System.out.println("Korrekt svar!" + " uttelling: " + oppg.vektetScore(svar)); 
			System.exit(0); 
		}
		else {
			System.out.println("Feil svar! ingen utelling.."); 
			System.exit(0); 
		}
	}
}