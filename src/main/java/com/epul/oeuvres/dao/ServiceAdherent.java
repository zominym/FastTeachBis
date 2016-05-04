package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.entities.Adherent;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceAdherent extends EntityService {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertAdherent(Adherent unAdherent) throws MonException {
		try {
			EntityTransaction transac = startTransaction();
			if (!entitymanager.contains(unAdherent)) {
				transac.begin();
				entitymanager.merge(unAdherent);
				entitymanager.flush();
				transac.commit();
			}
			entitymanager.close();
		} catch (Exception e) {
			new MonException("Erreur d'insertion", e.getMessage());
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		List<Adherent> mesAdherents= null;
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesAdherents = (List<Adherent>)  entitymanager.createQuery("SELECT a FROM Adherent a").getResultList();
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return mesAdherents;
	}

	public void updaterAdherent(Adherent unAdherent, int idAdherent)  throws MonException {
		unAdherent.setIdAdherent(idAdherent);
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.merge(unAdherent);
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}

//		String mysql;
//
//		DialogueBd unDialogueBd = DialogueBd.getInstance();
//		try {
//			mysql = "update adherent set nom_adherent = '" + unAdherent.getNomAdherent() +
//					"', prenom_adherent ='" + unAdherent.getPrenomAdherent() + "', ville_adherent='"
//					+ unAdherent.getVilleAdherent() + "' where id_adherent=" + idAdherent;
//
//			unDialogueBd.insertionBD(mysql);
//		} catch (MonException e) {
//			throw e;
//		}
	}

	public Adherent consulterAdherent(int numero) throws MonException {
		Adherent unAd = null;
		try {

			EntityTransaction transac = startTransaction();
			transac.begin();
			unAd = entitymanager.find(Adherent.class, numero);
			entitymanager.close();
			emf.close();

		} catch (Exception e) {
			new MonException("Erreur de lecture", e.getMessage());
		}
		return unAd;
	}

	public void supprimerAdherent(int idAdherent) throws MonException {
		Adherent a = consulterAdherent(idAdherent);

		try {
		EntityTransaction transac = startTransaction();
		transac.begin();
		entitymanager.remove(a);
		entitymanager.close();
		emf.close();

		} catch (Exception e) {
			new MonException("Erreur de lecture", e.getMessage());
		}
	}
}
