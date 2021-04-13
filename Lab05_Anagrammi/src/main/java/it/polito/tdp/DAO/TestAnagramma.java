package it.polito.tdp.DAO;

import java.util.HashMap;
import java.util.List;

import it.polito.tdp.DAO.AnagrammaDAO;

public class TestAnagramma {
	
	public static void main (String args[]) {
		AnagrammaDAO a = new AnagrammaDAO();
		HashMap<String, Boolean> anagrammi;
		anagrammi= a.anagrammi("abaca");
		System.out.println(anagrammi);
	}
}
