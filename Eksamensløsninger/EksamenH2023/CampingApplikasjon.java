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


public class CampingApplikasjon extends Application {

	//2a) 

	//tre instanser av ArrayList 
	private ArrayList<Kunde> kundeTab = new ArrayList<>(); 
	private ArrayList<UtleieObjekt> utleieObjektTab = new ArrayList<>(); 
	private ArrayList<Utleie> utleieTab = new ArrayList<>(); 



	//metode som finner kunde 
	private Kunde finnKunde(String tlf) {
		for(Kunde k: kundeTab) {
			if(k.getTlf().equals(tlf)) {
				return k; 
			}
		}
		return null; 
	}

	//metode som finner utleieobjekt
	private UtleieObjekt finnUtleieObj(int id) {
		for(UtleieObjekt uo: utleieObjektTab) {
			if(uo.getId() == id) {
				return uo;
			}
		}
		return null; 
	}

	//2b) 

	//deklarerer knapper som skal eksistere i hele programmet 
	private Button btLeieHytte = new Button("Leie hytte"); 
	private Button btLeieTilfPlass = new Button("Leie tilf plass");
	private Button btLeieFastPlass = new Button("Leie fast plass");
	private Button btNyHytte = new Button("Ny hytte");
	private Button btNyTilfPlass = new Button("Ny tilf plass");
	private Button btNyFastPlass = new Button("Ny fast plass");

	//deklarerer tekstfelt som skal eksistere i hele programmet 
	private TextField tfKundeTlf, tfKundeNavn, tfStartDato, tfSluttDato; 

	//Oppretter hovedpanel som skal eksistere i hele applikasjonen 
	private BorderPane hovedPanel; 

	@Override
	public void start(Stage stage) throws Exception {
		//Oppretter hovedpanelet 
		hovedPanel = new BorderPane();

		//setter overskriftspanel øverst 
		hovedPanel.setTop(overskriftsPanel());

		//legger til lytter på leiehytte knapp 
		btLeieHytte.setOnAction(e -> {
			//legger tekstfelt panel i senter 
			hovedPanel.setCenter(leieHyttePanel());
		});

		//setter knappe panel til venstre 
		hovedPanel.setLeft(knappePanel()); 

		Scene scene = new Scene(hovedPanel, 600, 400); 
		stage.setScene(scene); 
		stage.setTitle("Camping!"); 
		stage.show(); 
	}	

	//metode som oppretter overskriftspanel 
	public StackPane overskriftsPanel() {
		StackPane overskriftsPanel = new StackPane();
	
		Text overskrift = new Text("Camping"); 
		//lager font antar at den er bold med størrelse ca.24
		overskrift.setFont(Font.font("Times New Roman", 
				FontWeight.BOLD, 24)); 

		//legger til elementer til panel 
		overskriftsPanel.getChildren().add(overskrift);

		//legger til kant 
		leggTilKant(overskriftsPanel); 
		
		return overskriftsPanel;  
	}

	//metode som oppretter knappepanel 
	public VBox knappePanel() {
		VBox knappePanel = new VBox(); 
		knappePanel.setAlignment(Pos.TOP_CENTER); 
		knappePanel.setPadding(new Insets(10)); 
		knappePanel.setSpacing(10);

		//legger til knapper 
		knappePanel.getChildren().addAll(btLeieHytte, btLeieTilfPlass, 
						btLeieFastPlass, btNyHytte, 
						btNyTilfPlass, btNyFastPlass);

		//legger til kant 
		leggTilKant(knappePanel); 
		
		return knappePanel; 
	}


	//metode som oppretter panel med tekstfelt for leie hytte input 
	public GridPane leieHyttePanel() {
		GridPane leieHyttePanel = new GridPane(); 
		//sentrerer elementer 
		leieHyttePanel.setPadding(new Insets(10, 10, 10, 10)); 
		leieHyttePanel.setHgap(5); 
		leieHyttePanel.setVgap(5); 
		//Oppretter leie hytte overksrift
		Text overskrift = new Text("Leie hytte"); 
		//lager font antar at den er bold med størrelse ca.20
		overskrift.setFont(Font.font("Times New Roman", 
				FontWeight.BOLD, 20));
		//setter elementer i riktig posisjon 
		leieHyttePanel.add(overskrift, 1, 0); 
		leieHyttePanel.add(new Label("Kundens telefon:") , 0, 1);
		leieHyttePanel.add(tfKundeTlf = new TextField(), 1, 1);
		leieHyttePanel.add(new Label("Kundens navn:") , 0, 2);
		leieHyttePanel.add(tfKundeNavn = new TextField(), 1, 2);
		leieHyttePanel.add(new Label("Startdato:") , 0, 3);
		leieHyttePanel.add(tfStartDato = new TextField(), 1, 3);
		leieHyttePanel.add(new Label("Sluttdato:") , 0, 4);
		leieHyttePanel.add(tfSluttDato = new TextField(), 1, 4);
		//legger til kant 
		leggTilKant(leieHyttePanel);		
		//legger til lytter til tekstfelt for tlf og navn
		tfKundeTlf.setOnAction(e -> fyllInfo());
		return leieHyttePanel; 
	}

	//metode som fyller tekstfelt med info 
	public void fyllInfo() {
		String tlf = tfKundeTlf.getText(); 
		Kunde k = finnKunde(tlf);

		if(k != null) {
			 tfKundeNavn.setText(k.getNavn()); 
		}
		else {
			tfKundeNavn.setOnAction(e -> {
				Kunde nyKunde = new Kunde(tfKundeNavn.getText(), 
											tfKundeTlf.getText());
				kundeTab.add(nyKunde); 
				System.out.println("Kunde: " + nyKunde + " er lag til"); 
			});
		}
	}
	
	//metode som legger til kant 
	public void leggTilKant(Node panel) {
		panel.setStyle("-fx-background-color: #d3d3d3;" +  
				"-fx-border-width: 2px;" +  
				"-fx-border-color: black;"); 
	}
	
}