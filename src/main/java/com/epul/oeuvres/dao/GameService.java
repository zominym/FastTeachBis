package com.epul.oeuvres.dao;

import com.epul.oeuvres.entities.Action;
import com.epul.oeuvres.entities.Game;
import com.epul.oeuvres.entities.Mission;
import com.epul.oeuvres.entities.Objective;
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

	public List<Mission> getGameMissions(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Mission> query = entitymanager.createQuery(
				"SELECT m FROM Mission m, GameMissions gm  " +
						"WHERE m.missionId=gm.missionId " +
						"AND gm.gameId = :id", Mission.class);
		List<Mission> result = query.setParameter("id", ID).getResultList();
		emf.close();
		return result;
	}

	public Game getGame(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		Game result = entitymanager.find(Game.class, ID);
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

	public Mission getMission(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		Mission result = entitymanager.find(Mission.class, ID);
		emf.close();
		return result;
	}

	public List<Objective> getMissionObjectives(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Objective> query = entitymanager.createQuery(
				"SELECT o FROM Objective o " +
						"WHERE o.missionId = :id", Objective.class);
		List<Objective> result = query.setParameter("id", ID).getResultList();
		emf.close();
		return result;
	}

	public Objective getObjective(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		Objective result = entitymanager.find(Objective.class, ID);
		emf.close();
		return result;
	}

	public List<Action> getObjectiveActions(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Action> query = entitymanager.createQuery(
				"SELECT a FROM Action a, ObjectiveActions oa " +
						"WHERE oa.actionId = a.actionId " +
						"AND oa.objectiveId = :id", Action.class);
		List<Action> result = query.setParameter("id", ID).getResultList();
		emf.close();
		return result;
	}

	public Action getAction(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		Action result = entitymanager.find(Action.class, ID);
		emf.close();
		return result;
	}

	public List<Action> getActionChildren(int ID) {
		EntityTransaction transaction = startTransaction();
		transaction.begin();
		TypedQuery<Action> query = entitymanager.createQuery(
				"SELECT a FROM Action a " +
						"WHERE a.successor = :id", Action.class);
		List<Action> result = query.setParameter("id", ID).getResultList();
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
