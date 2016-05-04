package com.epul.oeuvres.dao;

import java.util.ArrayList;
import java.util.List;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Adherent;
import com.epul.oeuvres.metier.Oeuvrepret;
import com.epul.oeuvres.persistance.DialogueBd;

import javax.persistence.EntityTransaction;

public class ServiceOeuvrepret extends EntityService {

	public List<Oeuvrepret> consulterListeOeuvreprets() throws MonException {
		List<Oeuvrepret> mesOeuvreprets= null;
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesOeuvreprets = (List<Oeuvrepret>)  entitymanager.createQuery("SELECT a FROM Oeuvrepret a ORDER BY a.nomOeuvrepret").getResultList();
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return mesOeuvreprets;
	}
}
