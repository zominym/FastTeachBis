package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.entities.*;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceProprietaire extends EntityService {

	public Proprietaire consulterProprietaire(int id) throws MonException {
		Proprietaire unProp = null;
		try {

			EntityTransaction transac = startTransaction();
			transac.begin();
			unProp = entitymanager.find(Proprietaire.class, id);
			entitymanager.close();
			emf.close();

		} catch (Exception e) {
			new MonException("Erreur de lecture", e.getMessage());
		}
		return unProp;
//		String mysql = "select * from proprietaire where id_proprietaire=" + id;
//		List<Proprietaire> mesProprietaires = consulterListeProprietaires(mysql);
//		if (mesProprietaires.isEmpty())
//			return null;
//		else {
//			return mesProprietaires.get(0);
//		}
	}
	
	public List<Proprietaire> consulterListeProprietaires() throws MonException {
		List<Proprietaire> mesProprietaires =  null;
		try {

			EntityTransaction transac = startTransaction();
			transac.begin();
			mesProprietaires = (List<Proprietaire>)  entitymanager.createQuery("SELECT p FROM Proprietaire p ORDER BY p.nomProprietaire").getResultList();
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return mesProprietaires;
		/*String mysql = "select * from proprietaire";
		return consulterListeProprietaires(mysql);*/
	}
	
	
	/*private List<Proprietaire> consulterListeProprietaires(String mysql) throws MonException {
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
	}*/
	
}
