package com.epul.oeuvres.controle;

//import javax.servlet.ServletContext;

//import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.dao.*;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.epul.metier.*;
//import com.epul.meserreurs.*;

///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@Controller
public class MultiControleur extends MultiActionController {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

	@RequestMapping("/users/list")
	public ModelAndView displayUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			UserService unService = new UserService();
			request.setAttribute("myUsers", unService.getUsers());
			destinationPage = "user/listUsers";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/trainees/list")
	public ModelAndView displayTrainees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			UserService unService = new UserService();
			request.setAttribute("myUsers", unService.getTrainees());
			destinationPage = "user/listUsers";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/trainers/list")
	public ModelAndView displayTrainers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			UserService unService = new UserService();
			request.setAttribute("myUsers", unService.getTrainers());
			destinationPage = "user/listUsers";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/trainee/details")
	public ModelAndView traineeDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		UserService us = new UserService();
		request.setAttribute("trainee", us.getUser(Integer.parseInt(request.getParameter("ID"))));

		GameService gs = new GameService();
		request.setAttribute("traineeGames", gs.getGamesOfLearner(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("traineeResults", us.getTraineeResults(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("allGames", gs.getGames());
		destinationPage = "user/traineeDetails";

		return new ModelAndView(destinationPage);
	}

	@RequestMapping("trainee/attribute/form")
	public ModelAndView attributeGame(HttpServletRequest request, HttpServletResponse response) {
		String destinationPage;

		UserService us = new UserService();
		request.setAttribute("myUsers", us.getTrainees());

		GameService gs = new GameService();
		request.setAttribute("myGames", gs.getGames());

		destinationPage = "user/attributeGameToTrainee";

		return new ModelAndView(destinationPage);
	}

	@RequestMapping("trainee/attribute/validation")
	public ModelAndView attributeValidation(HttpServletRequest request, HttpServletResponse response) {
		String destinationPage;

		try {
			int userId = request.getParameter("slcuser");
			int gameId = request.getParameter("slcgame");

			Registration register = new Registration();
			register.setUserId(userId);
			register.setGameId(gameId);

			RegistrationService rs = new RegistrationService();
			rs.insertRegistration(register);

			destinationPage = "/trainees/list";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" +destinationPage);

	}

	@RequestMapping("/trainer/details")
	public ModelAndView trainerDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		UserService us = new UserService();
		request.setAttribute("trainer", us.getUser(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("trainees", us.getTraineesFromTrainer(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "user/trainerDetails";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/games/list")
	public ModelAndView displayGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("games", gs.getGames());

		destinationPage = "game/listGames";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/game/details")
	public ModelAndView gameDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("game", gs.getGame(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("missions", gs.getGameMissions(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "game/gameDetails";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/mission/details")
	public ModelAndView missionDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("mission", gs.getMission(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("objectives", gs.getMissionObjectives(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "mission/missionDetails";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/objective/details")
	public ModelAndView objectiveDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("objective", gs.getObjective(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("actions", gs.getObjectiveActions(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "objective/objectiveDetails";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/action/details")
	public ModelAndView actionDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("action", gs.getAction(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("children", gs.getActionChildren(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "action/actionDetails";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/trainee/edit/form")
	public ModelAndView fillUpdateUserForm(HttpServletRequest request, HttpServletResponse response){
		String destinationPage;
		destinationPage = "user/updateUser";
		int id = Integer.parseInt(request.getParameter("ID"));
		try {
			User user = new UserService().getUser(id);
			request.setAttribute("item",user);
		} catch (MonException e) {
			e.printStackTrace();
		}
		return new ModelAndView(destinationPage);
	}

    @RequestMapping("trainee/edit/do")
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response){
        String destinationPage;

        try {
            User user = new User();
            user.setName(request.getParameter("txtfirstname"));
            user.setSurname(request.getParameter("txtname"));
            user.setMail(request.getParameter("txtemail"));
            user.setPass(request.getParameter("pwd"));

            UserService service = new UserService();
            service.updaterUser(user, Integer.parseInt(request.getParameter("ID")));

            destinationPage = "/trainees/list";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView("redirect:" +destinationPage);
    }

	@RequestMapping("/user/insert/form")
	public ModelAndView fillUserForm(HttpServletRequest request, HttpServletResponse response) {
		String destinationPage;

		destinationPage = "user/insertUser";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/user/insert/do")
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response) {
		String destinationPage;

		try {
			User user = new User();
			user.setName(request.getParameter("txtfirstname"));
			user.setSurname(request.getParameter("txtname"));
			user.setMail(request.getParameter("txtemail"));
			user.setPass(request.getParameter("pwd"));
			user.setRole(request.getParameter("slcrole"));

			UserService service = new UserService();
			service.insertUser(user);

			destinationPage = "/trainees/list";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" +destinationPage);
	}

	@RequestMapping("/game/insert/form")
	public ModelAndView fillGameForm(HttpServletRequest request, HttpServletResponse response) {
		String destinationPage;

		destinationPage = "game/insertGame";
		return new ModelAndView(destinationPage);
	}

    @RequestMapping("/game/insert/do")
    public ModelAndView insertGame(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage;

        try {
            Game game = new Game();
            game.setGameLabel(request.getParameter("txtlabel"));
            GameService service = new GameService();
            service.insertGame(game);

            destinationPage = "/games/list";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView("redirect:" + destinationPage);
    }



	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("home");
	}

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("home");
	}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("erreur");
	}

}