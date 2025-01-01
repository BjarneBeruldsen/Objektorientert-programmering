import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Simulering extends Application{
	//knapper som skal gjennbrukes 
	private Button btRegKunde, btInnReg, btInnTilf, btUtKunde; 
	private TextField tfRegNr, tfNavn, tfAdresse, tfRegNrTilf;
	private ComboBox<String> cbRegNrIn, cbRegNrUt; 
	
	
	TextArea taInfofelt; 

	
	BorderPane hovedPanel = new BorderPane(); 
	
	//Oppretter parkeringhus 
	Parkeringshus parkeringshus = new Parkeringshus(50, 100); 
	
	@Override 
	public void start(Stage stage) throws Exception {
		hovedPanel = new BorderPane(); 
		
		hovedPanel.setTop(fyllInnPanel()); 
		
		//legger til lyttere til de fire knappene 
		btRegKunde.setOnAction(e -> regKunde()); 
		btInnReg.setOnAction(e -> regKundeInn()); 
		btInnTilf.setOnAction(e -> tilfKundeInn()); 
		btUtKunde.setOnAction(e -> utKunde()); 
		
		taInfofelt = new TextArea(); 
		taInfofelt.setEditable(false); 
		taInfofelt.setPrefColumnCount(30); 
		taInfofelt.setPrefRowCount(10);
		hovedPanel.setCenter(taInfofelt); 
		
		Scene scene = new Scene(hovedPanel); 
		stage.setScene(scene); 
		stage.setTitle("Parkeringshus"); 
		stage.show(); 
	}
	
	public GridPane fyllInnPanel() {
		GridPane panel = new GridPane(); 
		panel.setPadding(new Insets(10)); 
		
		Label lblOverksrift = new Label("");
		lblOverksrift.setTextFill(Color.RED); 
		 
		panel.add(lblOverksrift = new Label("Registrer kunde"), 0, 0); 
		lblOverksrift.setTextFill(Color.RED);
		panel.add(new Label("Reg.nr"), 0, 1); 
		panel.add(tfRegNr = new TextField(), 1, 1);
		panel.add(new Label("Navn:"), 0, 2); 
		panel.add(tfNavn = new TextField(), 1, 2);
		panel.add(new Label("Adresse:"), 0, 3); 
		panel.add(tfAdresse = new TextField(), 1, 3);
		panel.add(btRegKunde = new Button("Registrer kunde!"), 2, 3);
		panel.add(lblOverksrift = new Label("Registrert kunde inn"), 0, 4);
		lblOverksrift.setTextFill(Color.RED); 
		panel.add(new Label("Reg.nr"), 0, 5); 
		panel.add(cbRegNrIn = new ComboBox<String>(), 1, 5);
		panel.add(btInnReg = new Button("Inn registrert kunde!"), 2, 5);
		panel.add(lblOverksrift = new Label("Tilfeldig kunde inn"), 0, 6); 
		lblOverksrift.setTextFill(Color.RED); 
		panel.add(new Label("Reg.nr"), 0, 7); 
		panel.add(tfRegNrTilf = new TextField(), 1, 7);
		panel.add(btInnTilf = new Button("Inn tilfeldig kunde!"), 2, 7);
		panel.add(lblOverksrift = new Label("Kunde ut"), 0, 8); 
		lblOverksrift.setTextFill(Color.RED); 
		panel.add(new Label("Reg.nr"), 0, 9); 
		panel.add(cbRegNrUt = new ComboBox<String>(), 1, 9);
		panel.add(btUtKunde = new Button("Ut kunde!"), 2, 9);
		
		return panel; 
	}
	
	//metode for registrering av kunde 
	public void regKunde() {
		String regNr = tfRegNr.getText(); 
		String navn = tfNavn.getText();
		String adresse = tfAdresse.getText(); 
		RegistrertKunde k = new RegistrertKunde(regNr, navn, adresse); 				
		parkeringshus.regKunde(k);
		cbRegNrIn.getItems().add(regNr); 
		skrivUt("Registrert kunde " + k); 
	}
	
	public void regKundeInn() {
		String regNr = cbRegNrIn.getValue(); 
		cbRegNrUt.getItems().add(regNr); 
		parkeringshus.inn(regNr, new Date()); 
		skrivUt("Registrert kunde inn:" + parkeringshus.finnKunde(regNr) + '\n' + 
						status()); 
	}
	
	public void tilfKundeInn() {
		String regNr = tfRegNrTilf.getText(); 
		parkeringshus.inn(regNr, new Date()); 
		cbRegNrUt.getItems().add(regNr); 
		skrivUt("Tilfeldig kunde inn:" + regNr + '\n' + 
						status()); 
	}
	
	public void utKunde() {
		String regNr = cbRegNrUt.getValue(); 
		parkeringshus.ut(regNr, new Date()); 
		cbRegNrUt.getItems().remove(regNr); 
		skrivUt("Kunde ut:"+regNr + '\n' + 
				status()); 
	}

	public String status() {
		return parkeringshus.getAntLedigPlasser() + " av " 
				+ parkeringshus.getAntPlasser() + " ledige";
	}
	

	//legger til tekst til tekstområde 
	public void skrivUt(String ut) {
		taInfofelt.appendText(ut+'\n'); 
	} 
}