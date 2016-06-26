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


//
//	@RequestMapping("modifierAdherent")
//	public ModelAndView modifierAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String destinationPage;
//		try {
//			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
//			request.setAttribute("idAdherent", idAdherent);
//			destinationPage = "modifierAdherent";
//		} catch (Exception e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
//		return new ModelAndView(destinationPage);
//	}
//	@RequestMapping("updaterAdherent")
//	public ModelAndView updaterAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String destinationPage;
//		try {
//			ServiceAdherent unService = new ServiceAdherent();
//			Adherent unAdherent = unService.consulterAdherent(Integer.parseInt(request.getParameter("idAdherent")));
//			unAdherent.setNomAdherent(request.getParameter("txtnom"));
//			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
//			unAdherent.setVilleAdherent(request.getParameter("txtville"));
//			unService.updaterAdherent(unAdherent, 0);
//
//			destinationPage = "listerAdherent";
//		} catch (Exception e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
//		return new ModelAndView("redirect:" + destinationPage);
//	}
//	@RequestMapping("supprimerAdherent")
//	public ModelAndView supprimerAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String destinationPage;
//		try {
//			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
//			ServiceAdherent unService = new ServiceAdherent();
//			unService.supprimerAdherent(idAdherent);
//
//			destinationPage = "listerAdherent";
//		} catch (Exception e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
//		return new ModelAndView("redirect:" + destinationPage);
//	}
//	@RequestMapping("ajouterOeuvreVente")
//	public ModelAndView ajouterOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String destinationPage;
//		try {
//			int idProprietaire = (int) Float.parseFloat(request.getParameter("idProprietaire"));
//			System.out.println(idProprietaire);
//			request.setAttribute("idProprietaire", idProprietaire);
//			destinationPage = "ajouterOeuvreVente";
//		} catch (Exception e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
//		return new ModelAndView(destinationPage);
//	}
//	@RequestMapping("insererOeuvreVente")
//	public ModelAndView insererOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String destinationPage;
//		try {
//			String tempstring = request.getParameter("idProprietaire");
//			System.out.println(tempstring);
//			float tempfloat = Float.parseFloat(tempstring);
//			System.out.println(tempfloat);
//			int idProprietaire = (int) tempfloat;
//			Oeuvrevente uneOeuvrevente = new Oeuvrevente();
//			uneOeuvrevente.setTitreOeuvrevente(request.getParameter("txtnom"));
//			uneOeuvrevente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("numprix")));
//			ServiceOeuvrevente unService = new ServiceOeuvrevente();
//			unService.insererOeuvrevente(uneOeuvrevente, idProprietaire);
//
//			destinationPage = "listerOeuvres";
//		} catch (Exception e) {
//			request.setAttribute("MesErreurs", e.getMessage());
//			destinationPage = "erreur";
//		}
//		return new ModelAndView("redirect:" + destinationPage);
//	}
}