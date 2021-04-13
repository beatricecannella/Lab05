package it.polito.tdp.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnagrammaDAO {

	public HashMap<String, Boolean> anagrammi(String parola){
		//ArrayList<String> soluzione = new ArrayList<>();
		HashMap<String, Boolean> soluzione = new HashMap<String,Boolean>();
		doRicorsione("", parola, 0, soluzione); //parola = lettere che mancano... al livello 0, tutte le lettere
													// della parola non sono state usata
		
		return soluzione;
	}
	
	private void doRicorsione(String soluzioneParziale, String lettere, int livello, Map<String, Boolean> soluzione){
		
		//caso terminale
		if(lettere.length()==0) { //soluzioneParziale.length()==livello
			soluzione.put(soluzioneParziale, this.isValid(soluzioneParziale));
		}
		else {
			for(int i = 0; i<lettere.length(); i++) {
			char c = lettere.charAt(i);
			String nuovaParziale = soluzioneParziale + c ;
			String nuovaLettere = lettere.substring(0,i)+lettere.substring(i+1);
			doRicorsione(nuovaParziale, nuovaLettere, livello+1, soluzione);
			}
		}
		
	}

	public boolean isValid(String soluzione) {
		String sql = "SELECT * FROM parola WHERE parola.nome=?";
		boolean valido = false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, soluzione);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				valido = true;
			}
			
			conn.close();
			return valido;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}
	
}
