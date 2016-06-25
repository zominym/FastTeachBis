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
//		TypedQuery<Game> query = entitymanager.createQuery(
//				"SELECT g FROM Game g JOIN g.Registration r  " +
//						"on g.gameId=r.gameId " +
//						"WHERE r.traineeId = :id", Game.class);
		TypedQuery<Game> query = entitymanager.createQuery(
		"SELECT g FROM Game g, Registration r  " +
				"WHERE g.gameId=r.gameId " +
				"AND r.traineeId = :id", Game.class);
		List<Game> result = query.setParameter("id", learner).getResultList();
		emf.close();
		return result;
	}

}
