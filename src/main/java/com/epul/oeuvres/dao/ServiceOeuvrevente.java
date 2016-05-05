package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.entities.*;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvrevente extends EntityService{
    public List<Oeuvrevente> consulterListeOeuvreventes() throws MonException {

        List<Oeuvrevente> mesOeuvres= null;
        try {

            EntityTransaction transac = startTransaction();
            transac.begin();
            mesOeuvres = (List<Oeuvrevente>)  entitymanager.createQuery("SELECT o FROM Oeuvrevente o").getResultList();
            entitymanager.close();
        }  catch (RuntimeException e){
            new MonException("Erreur de lecture ", e.getMessage());
        }
        return mesOeuvres;

        /*String mysql = "select * from oeuvrevente;";
        //System.out.println(mysql);
        return consulterListeOeuvreventes(mysql);*/
    }

    public Oeuvrevente getOeuvrevente(int idOeuvrevente) throws MonException {

        Oeuvrevente uneOeuvre = null;
        try {

            EntityTransaction transac = startTransaction();
            transac.begin();
            uneOeuvre = entitymanager.find(Oeuvrevente.class, idOeuvrevente);
            entitymanager.close();
            emf.close();

        } catch (Exception e) {
            new MonException("Erreur de lecture", e.getMessage());
        }
        return uneOeuvre;
    }

	public void insererOeuvrevente(Oeuvrevente uneOeuvrevente, int idProprietaire) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            Proprietaire p = entitymanager.find(Proprietaire.class, idProprietaire);
            uneOeuvrevente.setIdProprietaire(p);
            uneOeuvrevente.setEtatOeuvrevente("L");
            entitymanager.merge(uneOeuvrevente);
            entitymanager.flush();
            transac.commit();
            entitymanager.close();
        } catch (Exception e) {
            System.err.println("Erreur d'insertion :"+e.getMessage());
            new MonException("Erreur d'insertion", e.getMessage());
        }

		/*String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();

		mysql = "insert into oeuvrevente (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)"
		+ "values ('"+ uneOeuvrevente.getTitreOeuvrevente() + "','"
		+ "L" + "','"
		+ uneOeuvrevente.getPrixOeuvrevente() + "','"
		+ idAdherent + "')";

		unDialogueBd.insertionBD(mysql);*/
		
	}

	public void supprimerOeuvrevente(int idOeuvrevente) throws MonException {

        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            Oeuvrevente unAd = entitymanager.find(Oeuvrevente.class, idOeuvrevente);
            entitymanager.remove(unAd);
            entitymanager.flush();
            transac.commit();
            entitymanager.close();
            emf.close();

        } catch (Exception e) {
            System.err.println("Erreur de lecture: "+e.getMessage());
            new MonException("Erreur de lecture", e.getMessage());
        }

		/*String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		
		mysql = "delete from oeuvrevente where id_oeuvrevente=" + idOeuvrevente;

		unDialogueBd.insertionBD(mysql);*/
	}

    public void reserverOeuvrevente(int idOeuvrevente, int idAdherent) throws MonException {

        try {

            EntityTransaction transac = startTransaction();
            transac.begin();
            Oeuvrevente uneOeuvre = entitymanager.find(Oeuvrevente.class, idOeuvrevente);
            uneOeuvre.setEtatOeuvrevente("R");
            ServiceReservation sr = new ServiceReservation();
            sr.insererReservation(idOeuvrevente, idAdherent);
            entitymanager.merge(uneOeuvre);
            entitymanager.flush();
            transac.commit();
            entitymanager.close();
        }  catch (RuntimeException e){
            new MonException("Erreur de lecture ", e.getMessage());
        }

        /*String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();

        mysql = "update oeuvrevente set etat_oeuvrevente='R' where id_oeuvrevente="+idOeuvrevente;

        unDialogueBd.insertionBD(mysql);

        mysql = "insert into reservation values("+idOeuvrevente+","+idAdherent+", DATE(NOW()),'confirmee')";

        unDialogueBd.insertionBD(mysql);*/
    }
}
