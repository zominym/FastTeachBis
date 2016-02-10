package dao;

import java.util.ArrayList;
import java.util.List;

import meserreurs.MonException;
import metier.Proprietaire;
import persistance.DialogueBd;

public class ServiceProprietaire {

	public Proprietaire consulterProprietaire(String id) throws MonException {
		String mysql = "select * from proprietaire where id_proprietaire=" + id;
		List<Proprietaire> mesProprietaires = consulterListeProprietaires(mysql);
		if (mesProprietaires.isEmpty())
			return null;
		else {
			return mesProprietaires.get(0);
		}
	}
	
	public List<Proprietaire> consulterListeProprietaires() throws MonException {
		String mysql = "select * from proprietaire";
		return consulterListeProprietaires(mysql);
	}
	
	
	private List<Proprietaire> consulterListeProprietaires(String mysql) throws MonException {
		List<Object> rs;
		List<Proprietaire> mesProprietaires = new ArrayList<Proprietaire>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage
				Proprietaire unA = new Proprietaire();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomProprietaire(rs.get(index + 1).toString());
				unA.setPrenomProprietaire(rs.get(index + 2).toString());
				// On incrémente tous les 3 champs
				index = index + 3;
				mesProprietaires.add(unA);
			}

			return mesProprietaires;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
}
