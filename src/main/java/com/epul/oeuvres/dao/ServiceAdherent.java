package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;

import com.epul.oeuvres.metier.*;
import com.epul.oeuvres.persistance.*;

import javax.persistence.EntityTransaction;

public class ServiceAdherent extends EntityService {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		String mysql = "select * from adherent where numero_adherent=" + numero;
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	}

	public Adherent getAdherent(int idAdherent) throws MonException {
        List<Adherent> list = consulterListeAdherents();
        for (Adherent a: list) {
            if(a.getIdAdherent() == idAdherent)
                return a;
        }
        return null;
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void updaterAdherent(Adherent unAdherent, int idAdherent)  throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update adherent set nom_adherent = '" + unAdherent.getNomAdherent() +
					"', prenom_adherent ='" + unAdherent.getPrenomAdherent() + "', ville_adherent='"
					+ unAdherent.getVilleAdherent() + "' where id_adherent=" + idAdherent;

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
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
//		String mysql;
//
//		DialogueBd unDialogueBd = DialogueBd.getInstance();
//		try {
//			mysql = "delete from adherent where id_adherent=" + idAdherent;
//
//			unDialogueBd.insertionBD(mysql);
//		} catch (MonException e) {
//			throw e;
//		}

		// Initialize vars
		EntityTransaction transaction = this.entityManager.getTransaction();

		// Delete the adherent
		try
		{
			transaction.begin();
			this.entityManager.remove(adherent);
			this.entityManager.flush();
			transaction.commit();
		}
		catch(Exception ex)
		{
			transaction.rollback();

			throw new RepositoryException(
					ex,
					"Impossible de supprimer l'adhérent."
			);
		}
		
	}

}
