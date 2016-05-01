package com.epul.oeuvres.dao;

import java.util.ArrayList;
import java.util.List;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Proprietaire;
import com.epul.oeuvres.persistance.DialogueBd;

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
				// On cr�e un stage
				Proprietaire unA = new Proprietaire();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomProprietaire(rs.get(index + 1).toString());
				unA.setPrenomProprietaire(rs.get(index + 2).toString());
				// On incr�mente tous les 3 champs
				index = index + 3;
				mesProprietaires.add(unA);
			}

			return mesProprietaires;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
}
