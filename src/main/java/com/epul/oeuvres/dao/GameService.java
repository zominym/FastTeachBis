package com.epul.oeuvres.dao;

import com.epul.oeuvres.entities.Game;
import com.epul.oeuvres.meserreurs.MonException;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class GameService extends EntityService {


	/**
	 * permet de récupérer la liste des jeux d'un apprenant
	 * @param learner
	 * @return
	 */
	public List<Game> getGamesOfLearner(int learner) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Game> query = entitymanager.createQuery(
		"SELECT g FROM Game g, Registration r  " +
				"WHERE g.gameId=r.gameId " +
				"AND r.traineeId = :id", Game.class);
		List<Game> result = query.setParameter("id", learner).getResultList();
		emf.close();
		return result;
	}

	public List<Game> getGames() {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Game> query = entitymanager.createQuery("SELECT g FROM Game g", Game.class);
		List<Game> result = query.getResultList();
		emf.close();
		return result;
	}


	public void insertGame(Game game) {
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.persist(game);
			//entitymanager.merge(game);
			entitymanager.flush();
			transac.commit();
			entitymanager.close();
		} catch (Exception e) {
			new MonException("Erreur d'insertion", e.getMessage());
		}
	}
}
