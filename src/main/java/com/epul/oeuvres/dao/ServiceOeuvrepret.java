package com.epul.oeuvres.dao;

import java.util.ArrayList;
import java.util.List;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Oeuvrepret;
import com.epul.oeuvres.persistance.DialogueBd;

public class ServiceOeuvrepret {
	
	public List<Oeuvrepret> consulterListeOeuvreprets() throws MonException {
		String mysql = "select * from oeuvrepret";
		return consulterListeOeuvreprets(mysql);
	}

	private List<Oeuvrepret> consulterListeOeuvreprets(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrepret> mesOeuvreprets = new ArrayList<Oeuvrepret>();
		int index = 0;
		try {
			ServiceProprietaire SP = new ServiceProprietaire();
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage
				Oeuvrepret uneOeuvre = new Oeuvrepret();
				// il faut redecouper la liste pour retrouver les lignes
				uneOeuvre.setIdOeuvrepret(Integer.parseInt(rs.get(index + 0).toString()));
				uneOeuvre.setTitreOeuvrepret(rs.get(index + 1).toString());
				uneOeuvre.setProprietaire(SP.consulterProprietaire(rs.get(index + 2).toString()));
				// On incrémente tous les 3 champs
				index = index + 3;
				mesOeuvreprets.add(uneOeuvre);
			}

			return mesOeuvreprets;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
}
