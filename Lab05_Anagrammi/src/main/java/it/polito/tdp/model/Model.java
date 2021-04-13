package it.polito.tdp.model;

import java.util.HashMap;

import it.polito.tdp.DAO.AnagrammaDAO;

public class Model {
	AnagrammaDAO aDAO = new AnagrammaDAO();
	
	public HashMap<String, Boolean> anagrammi(String parola){
		return aDAO.anagrammi(parola);
	}
}
