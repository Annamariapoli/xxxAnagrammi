package application;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {

	private Model m = new Model();
	
	public void setModel(Model m){
		this.m=m;
	}
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSequenza;

    @FXML
    private Button btnStatistica;

    @FXML
    private Button btnSuper;

    @FXML
    private TextArea txtResult;

    @FXML
    void doStatistica(ActionEvent event) {
    	txtResult.clear();
    	String sequenza = txtSequenza.getText();
    	sequenza.toLowerCase();
    	for(int i =0; i<sequenza.length(); i++){
    		if(!Character.isLetter(sequenza.charAt(i))){
    			txtResult.appendText("La sequenza deve essere costituita da caratteri!\n");
    			return;
    		}
    	}
    	if(sequenza.length()<=1){
    		txtResult.appendText("Inserisci una sequenza che contenga almeno due caratteri!\n");
    		return;
    	}
    	
    	int tot = m.somma(sequenza);
    	txtResult.appendText("Parole trovate con questa sequenza:  "+ tot+" \n");
    	

    	Map<Character, Integer> mappa = m.calcoloPerTutteLeLettere(sequenza);
    	txtResult.appendText(mappa.toString());    //la stampa
    }

    @FXML
    void doSuper(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtSequenza != null : "fx:id=\"txtSequenza\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnStatistica != null : "fx:id=\"btnStatistica\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnSuper != null : "fx:id=\"btnSuper\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
