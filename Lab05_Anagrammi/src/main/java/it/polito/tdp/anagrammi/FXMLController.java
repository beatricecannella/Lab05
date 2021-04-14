package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model = new Model();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnagramma;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola = this.txtAnagramma.getText();
    	
    	if(parola!=null) {	
    	
    		if(!parola.matches("[a-zA-Z?]*")) {
        		this.txtCorretti.setText("ERRORE: la parola non può contenere numeri!");
        		return;
        	}
    	ArrayList<String> paroleCorrette = new ArrayList<String>();
    	ArrayList<String> paroleErrate = new ArrayList<String>();
    	
    	HashMap<String, Boolean> parole = model.anagrammi(parola);
    	
    	
    	for(String s: parole.keySet()) {
    		if(parole.get(s) == false){
    			paroleErrate.add(s);
    		}
    		else {
    			paroleCorrette.add(s);
    		}   		
    	}
    	String elencoC ="";
    	for(String c: paroleCorrette) {
    		elencoC += c + "\n";
    	    	}
    		
    	String elencoE ="";
    	for(String e: paroleErrate) {
    		elencoE += e + "\n";
    	    	}
    	this.txtErrati.setText(elencoE);
    	this.txtCorretti.setText(elencoC);
    	}
    	else {
    		this.txtCorretti.setText("ERRORE: devi inserire una parola!");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAnagramma.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();

    }

    public void setModel(Model model) {
    	this.model=model;
    }
    
    @FXML
    void initialize() {
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
