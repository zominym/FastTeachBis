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
			destinationPage = "listUsers";
			System.err.println("CAN YOU SEE ME ???");
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
			destinationPage = "listUsers";
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
			destinationPage = "listUsers";
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

		destinationPage = "traineeDetails";

		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/trainer/details")
	public ModelAndView trainerDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
//		try {
		// HttpSession session = request.getSession();

		UserService us = new UserService();
		request.setAttribute("trainer", us.getUser(Integer.parseInt(request.getParameter("ID"))));

		request.setAttribute("trainees", us.getTraineesFromTrainer(Integer.parseInt(request.getParameter("ID"))));

		destinationPage = "trainerDetails";
//		} catch (MonException e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("/games/list")
	public ModelAndView displayGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;

		GameService gs = new GameService();
		request.setAttribute("games", gs.getGames());

		destinationPage = "listGames";
		return new ModelAndView(destinationPage);
	}


	@RequestMapping("insertUser")
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

			destinationPage = "trainees/list";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}

    @RequestMapping("insertGame")
    public ModelAndView insertGame(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage;

        try {
            Game game = new Game();
            game.setGameLabel(request.getParameter("txtlabel"));
            GameService service = new GameService();
            service.insertGame(game);

            destinationPage = "trainees/listGames";
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