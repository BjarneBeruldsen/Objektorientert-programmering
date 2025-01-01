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
import java.util.ArrayList;
public class ContainerGUI extends Application {
	//Oppretter containermodell 
	private ContainerModell cm;
	private Button btRegDag, btRegTime, btAvslutt, btRegCont; 
	private TextField tfDagAdresse, tfMinVol, tfTimeAdresse, tfLeieTid, 
										tfVolum, tfTimepris; 
	private ComboBox<String> cbAvslutt; 
	
	private TextArea taInfoFelt; 
	
	private BorderPane hovedPanel; 
	
	@Override
	public void start(Stage stage) throws Exception {
		//oppretter container modell objekt 
		cm = new ContainerModell(); 
	
		hovedPanel = new BorderPane(); 
		
		hovedPanel.setTop(fyllInnPanel()); 
		
		//legger lytter til knapper
		btRegDag.setOnAction(e -> regDag()); 
		btRegTime.setOnAction(e -> regTime()); 
		btAvslutt.setOnAction(e -> avslutt()); 
		btRegCont.setOnAction(e -> regCont()); 
		
		taInfoFelt = new TextArea(); 
		taInfoFelt.setEditable(false); 
		hovedPanel.setCenter(taInfoFelt); 
		
		Scene scene = new Scene(hovedPanel); 
		stage.setScene(scene); 
		stage.setTitle("Containermodell"); 
		stage.show(); 
	}
	
	public GridPane fyllInnPanel() {
		GridPane panel = new GridPane(); 
		panel.setPadding(new Insets(10)); 
		
		Label lblOverskrift = new Label("Registrer dagoppdrag"); 
		lblOverskrift.setTextFill(Color.RED); 
		
		//Registrering for dagoppdrag
		panel.add(lblOverskrift, 0, 0); 
		panel.add(new Label("Adresse:"), 0, 1); 
		panel.add(tfDagAdresse = new TextField(), 1, 1); 
		panel.add(new Label("Min. Volum:"), 0, 2); 
		panel.add(tfMinVol = new TextField(), 1, 2);
		panel.add(btRegDag = new Button("Reg.Dag"), 2, 2);
		
		//Registrering for timeoppdrag
		panel.add(lblOverskrift = new Label("Registrer timeoppdrag"), 0, 3);
		lblOverskrift.setTextFill(Color.RED);  
		panel.add(new Label("Adresse:"), 0, 4);  
		panel.add(tfTimeAdresse = new TextField(), 1, 4);
		panel.add(new Label("Leietid:"), 0, 5); 
		panel.add(tfLeieTid = new TextField(), 1, 5);
		panel.add(btRegTime = new Button("Reg.Time"), 2, 5);
		
		//avslutting av oppdrag 
		panel.add(lblOverskrift = new Label("Avslutt oppdrag"), 0, 6);
		lblOverskrift.setTextFill(Color.RED);
		panel.add(new Label("Adresse:"), 0, 7); 
		panel.add(cbAvslutt = new ComboBox<String>(), 1, 7);
		panel.add(btAvslutt = new Button("Avslutt"), 2, 7); 
		
		//registrering av ny kunde 
		panel.add(lblOverskrift = new Label("Reg. ny container"), 0, 8);
		lblOverskrift.setTextFill(Color.RED);
		panel.add(new Label("Volum:"), 0, 9); 
		panel.add(tfVolum = new TextField(), 1, 9); 
		panel.add(new Label("Timepris:"), 0, 10); 
		panel.add(tfTimepris = new TextField(), 1, 10);
		panel.add(btRegCont = new Button("Reg.Dag"), 2, 10);
		
		return panel; 
	}
	
	public void regDag() {
		String adresse = tfDagAdresse.getText(); 
		int minVolum = Integer.parseInt(tfMinVol.getText()); 
		DagOppdrag dagOpp = new DagOppdrag(adresse, minVolum); 
		String status = cm.regOppdrag(dagOpp); 
		//legger adresse til nedtrekksliste
		cbAvslutt.getItems().add(adresse); 
		taInfoFelt.appendText(status+'\n'); 
	}

	public void regTime() {
		String adresse = tfTimeAdresse.getText(); 
		int leieTid = Integer.parseInt(tfLeieTid.getText()); 
		TimeOppdrag timeOpp = new TimeOppdrag(adresse, leieTid); 
		String status = cm.regOppdrag(timeOpp); 
		//legger adresse til nedtrekksliste
		cbAvslutt.getItems().add(adresse); 
		taInfoFelt.appendText(status+'\n'); 
	}

	public void avslutt() {
		System.out.println("Før:"); 
		skrivUtOppdrag(); 
		String adresse = cbAvslutt.getValue(); 
		String status = cm.avsluttOppdrag(adresse);
		taInfoFelt.appendText(status+'\n');
		cbAvslutt.getItems().remove(adresse); 
		System.out.println("Etter:"); 
		skrivUtOppdrag(); 
	}

	public void regCont() {
		int v = Integer.parseInt(tfVolum.getText()); 
		double t = Double.parseDouble(tfTimepris.getText()); 
		String status = cm.nyContainer(v, t);
		taInfoFelt.appendText(status+'\n'); 
	}

	public void skrivUtOppdrag() {
		ArrayList<Oppdrag> oppdrag = cm.getOppdrag(); 
		for(Oppdrag o: oppdrag) {
			System.out.println(o.toString()); 
		}
	}
}