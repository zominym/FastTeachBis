package com.epul.oeuvres.dao;

import com.epul.oeuvres.entities.User;
import com.epul.oeuvres.meserreurs.MonException;

import javax.persistence.EntityTransaction;
import java.util.List;

public class UserService extends EntityService {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation
	public void insertUser(User unUser) throws MonException {
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.merge(unUser);
			entitymanager.flush();
			transac.commit();
			entitymanager.close();
		} catch (Exception e) {
			new MonException("Erreur d'insertion", e.getMessage());
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<User> getUsers() throws MonException {
		List<User> mesUsers = null;
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesUsers = (List<User>)  entitymanager.createQuery("SELECT u FROM User u").getResultList();
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return mesUsers;
	}

	public User getUser(int id) throws MonException {
		User myUser = null;
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
//			mesUsers = (List<User>)  entitymanager.createQuery("SELECT u FROM User u").getResultList();
			myUser = entitymanager.find(User.class, id);
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return myUser;
	}

	public List<User> getTrainees() throws MonException {
		List<User> mesUsers = null;
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesUsers = (List<User>)  entitymanager.createQuery("SELECT u FROM User u WHERE u.role = 'TRAINEE'").getResultList();
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}
		return mesUsers;
	}

    public List<User> getTrainers() throws MonException {
        List<User> mesUsers = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesUsers = (List<User>)  entitymanager.createQuery("SELECT u FROM User u WHERE u.role = 'TRAINER'").getResultList();
            entitymanager.close();
        }  catch (RuntimeException e){
            new MonException("Erreur de lecture ", e.getMessage());
        }
        return mesUsers;
    }

	public List<User> getTraineesFromTrainer(int idTrainer) throws MonException() {
		List<User> mesUsers = null;

		try {
			EntityTransaction transac = startTransaction();
			transac.begin();

			TypedQuery<User> query = entitymanager.createQuery(
					"SELECT u FROM User u, TrainingGroup t  " +
					"WHERE u.user_id = t.trainee_id " +
					"AND t.trainer_id = :id", User.class);

			mesUsers = query.setParameter("id", idTrainer).getResultList();
            entitymanager.close();
        }  catch (RuntimeException e){
            new MonException("Erreur de lecture ", e.getMessage());
        }
        return mesUsers;
	}

	public void updaterUser(User unUser, int idUser)  throws MonException {

		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.merge(unUser);
			entitymanager.flush();
			transac.commit();
			entitymanager.close();
		} catch (Exception e) {
			new MonException("Erreur d'insertion", e.getMessage());
		}

		/*unUser.setIdUser(idUser);
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.merge(unUser);
			entitymanager.close();
		}  catch (RuntimeException e){
			new MonException("Erreur de lecture ", e.getMessage());
		}*/

//		String mysql;
//
//		DialogueBd unDialogueBd = DialogueBd.getInstance();
//		try {
//			mysql = "update user set nom_user = '" + unUser.getNomUser() +
//					"', prenom_user ='" + unUser.getPrenomUser() + "', ville_user='"
//					+ unUser.getVilleUser() + "' where id_user=" + idUser;
//
//			unDialogueBd.insertionBD(mysql);
//		} catch (MonException e) {
//			throw e;
//		}
	}

	public User consulterUser(int numero) throws MonException {
		User unAd = null;
		try {

			EntityTransaction transac = startTransaction();
			transac.begin();
			unAd = entitymanager.find(User.class, numero);
			entitymanager.close();
			emf.close();

		} catch (Exception e) {
			new MonException("Erreur de lecture", e.getMessage());
		}
		return unAd;
	}

	public void supprimerUser(int id) throws MonException {
		try {
		EntityTransaction transac = startTransaction();
		transac.begin();
		User unAd = entitymanager.find(User.class, id);
		entitymanager.remove(unAd);
		entitymanager.flush();
		transac.commit();
		entitymanager.close();
		emf.close();

		} catch (Exception e) {
			System.err.println("Erreur de lecture: "+e.getMessage());
			new MonException("Erreur de lecture", e.getMessage());
		}
	}
}
