package com.epul.oeuvres.controle;

//import javax.servlet.ServletContext;

//import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.dao.*;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Adherent;
import com.epul.oeuvres.metier.Oeuvrevente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

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

	@RequestMapping("listerAdherent")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			ServiceAdherent unService = new ServiceAdherent();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());
			destinationPage = "listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping("insererAdherent")
	public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			Adherent unAdherent = new Adherent();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherent unService = new ServiceAdherent();
			unService.insertAdherent(unAdherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}
		destinationPage = "listerAdherent";
		return new ModelAndView("redirect:" + destinationPage);
	}

	@RequestMapping("ajouterAdherent")
	public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage;
		try {
			destinationPage = "ajouterAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}

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

	@RequestMapping("listerOeuvres")
	public ModelAndView listerOeuvres (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			ServiceOeuvrepret unServiceP = new ServiceOeuvrepret();
			request.setAttribute("mesOeuvreprets", unServiceP.consulterListeOeuvreprets());

			ServiceOeuvrevente unServiceV = new ServiceOeuvrevente();
			request.setAttribute("mesOeuvreventes", unServiceV.consulterListeOeuvreventes());

			ServiceAdherent unService = new ServiceAdherent();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());
			destinationPage = "listerOeuvres";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView(destinationPage);
	}
	@RequestMapping("modifierAdherent")
	public ModelAndView modifierAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			request.setAttribute("idAdherent", idAdherent);
			destinationPage = "modifierAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView(destinationPage);
	}
	@RequestMapping("updaterAdherent")
	public ModelAndView updaterAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			Adherent unAdherent = new Adherent();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherent unService = new ServiceAdherent();
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			unService.updaterAdherent(unAdherent, idAdherent);

			destinationPage = "listerAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}
	@RequestMapping("supprimerAdherent")
	public ModelAndView supprimerAdherent (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			ServiceAdherent unService = new ServiceAdherent();
			unService.supprimerAdherent(idAdherent);

			destinationPage = "listerAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}
	@RequestMapping("ajouterOeuvreVente")
	public ModelAndView ajouterOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			int idProprietaire = (int) Float.parseFloat(request.getParameter("idProprietaire"));
			System.out.println(idProprietaire);
			request.setAttribute("idProprietaire", idProprietaire);
			destinationPage = "ajouterOeuvreVente";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView(destinationPage);
	}
	@RequestMapping("insererOeuvreVente")
	public ModelAndView insererOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			String tempstring = request.getParameter("idProprietaire");
			System.out.println(tempstring);
			float tempfloat = Float.parseFloat(tempstring);
			System.out.println(tempfloat);
			int idProprietaire = (int) tempfloat;
			Oeuvrevente uneOeuvrevente = new Oeuvrevente();
			uneOeuvrevente.setTitreOeuvrevente(request.getParameter("txtnom"));
			uneOeuvrevente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("numprix")));
			ServiceOeuvrevente unService = new ServiceOeuvrevente();
			unService.insererOeuvrevente(uneOeuvrevente, idProprietaire);

			destinationPage = "listerOeuvres";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}
	@RequestMapping("listerProprietaires")
	public ModelAndView listerProprietaires (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			ServiceProprietaire unService = new ServiceProprietaire();
			request.setAttribute("mesProprietaires", unService.consulterListeProprietaires());

			destinationPage = "listerProprietaires";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView(destinationPage);
	}
	@RequestMapping("supprimerOeuvreVente")
	public ModelAndView supprimerOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			int idOeuvrevente = Integer.parseInt(request.getParameter("idOeuvrevente"));
			ServiceOeuvrevente unService = new ServiceOeuvrevente();
			unService.supprimerOeuvrevente(idOeuvrevente);

			destinationPage = "listerOeuvres";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}
	@RequestMapping("reserverOeuvreVente")
	public ModelAndView reserverOeuvreVente (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			int idOeuvrevente = Integer.parseInt(request.getParameter("idOeuvrevente"));
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			ServiceOeuvrevente unService = new ServiceOeuvrevente();

			if(!unService.getOeuvrevente(idOeuvrevente).isReserved()){
				unService.reserverOeuvrevente(idOeuvrevente,idAdherent);
			}

			destinationPage = "listerOeuvres";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView("redirect:" + destinationPage);
	}
	@RequestMapping("listerReservations")
	public ModelAndView listerReservations (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			ServiceReservation unService = new ServiceReservation();
			request.setAttribute("mesReservations", unService.consulterListeReservations());

			destinationPage = "listerReservations";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "erreur";
		}
		return new ModelAndView(destinationPage);
	}
}