package com.epul.oeuvres.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epul.oeuvres.dao.*;
import com.epul.oeuvres.metier.*;
import com.epul.oeuvres.meserreurs.*;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String LISTER_RADHERENT = "listerAdherent";//
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";//
	private static final String INSERER_ADHERENT = "insererAdherent";//
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";//
	
	private static final String LISTER_OEUVRES = "listerOeuvres";
	
	private static final String MODIFIER_ADHERENT = "modifierAdherent";
	private static final String UPDATER_ADHERENT = "updaterAdherent";
	
	private static final String SUPPRIMER_ADHERENT = "supprimerAdherent";
	
	private static final String AJOUTER_OEUVRE_VENTE = "ajouterOeuvreVente";
	private static final String INSERER_OEUVRE_VENTE = "insererOeuvreVente";
	
	private static final String LISTER_PROPRIETAIRES = "listerProprietaires";
	
	private static final String SUPPRIMER_OEUVRE_VENTE = "supprimerOeuvreVente";

    private static final String RESERVER_OEUVRE_VENTE = "reserverOeuvreVente";
    private static final String LISTER_RESERVATIONS = "listerReservations";



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processusTraiteRequete(request, response);
		} catch (MonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processusTraiteRequete(request, response);
		} catch (MonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MonException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		// execute l'action
		if (LISTER_RADHERENT.equals(actionName)) {

			ServiceAdherent unService = new ServiceAdherent();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());

			destinationPage = "/listerAdherent.jsp";
		}
		else if (LISTER_OEUVRES.equals(actionName)) {

			ServiceOeuvrepret unServiceP = new ServiceOeuvrepret();
			request.setAttribute("mesOeuvreprets", unServiceP.consulterListeOeuvreprets());

			ServiceOeuvrevente unServiceV = new ServiceOeuvrevente();
			request.setAttribute("mesOeuvreventes", unServiceV.consulterListeOeuvreventes());

			ServiceAdherent unService = new ServiceAdherent();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());

			destinationPage = "/listerOeuvres.jsp";
		}
		else if (AJOUTER_ADHERENT.equals(actionName)) {

			destinationPage = "/ajouterAdherent.jsp";
			
		} else if (INSERER_ADHERENT.equals(actionName)) {
			
			Adherent unAdherent = new Adherent();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherent unService = new ServiceAdherent();
			unService.insertAdherent(unAdherent);

			destinationPage = "/Controleur?action=listerAdherent";
		}
		else if (MODIFIER_ADHERENT.equals(actionName)) {
			
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			request.setAttribute("idAdherent", idAdherent);
			destinationPage = "/modifierAdherent.jsp";
			
		} else if (UPDATER_ADHERENT.equals(actionName)) {
			
			Adherent unAdherent = new Adherent();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherent unService = new ServiceAdherent();
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			unService.updaterAdherent(unAdherent, idAdherent);
			
			destinationPage = "/Controleur?action=listerAdherent";
		}
		
		else if (SUPPRIMER_ADHERENT.equals(actionName)) {
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			ServiceAdherent unService = new ServiceAdherent();
			unService.supprimerAdherent(idAdherent);
			
			destinationPage = "/Controleur?action=listerAdherent";
		}
		
		else if (AJOUTER_OEUVRE_VENTE.equals(actionName)) {
			
			int idProprietaire = (int) Float.parseFloat(request.getParameter("idProprietaire"));
			System.out.println(idProprietaire);
			request.setAttribute("idProprietaire", idProprietaire);
			destinationPage = "/ajouterOeuvreVente.jsp";
			
		} else if (INSERER_OEUVRE_VENTE.equals(actionName)) {
			
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
				
			destinationPage = "/Controleur?action=listerOeuvres";
		}
		
		else if (LISTER_PROPRIETAIRES.equals(actionName)) {

			ServiceProprietaire unService = new ServiceProprietaire();
			request.setAttribute("mesProprietaires", unService.consulterListeProprietaires());

			destinationPage = "/listerProprietaires.jsp";
		}
		
		else if (SUPPRIMER_OEUVRE_VENTE.equals(actionName)) {
			int idOeuvrevente = Integer.parseInt(request.getParameter("idOeuvrevente"));
			ServiceOeuvrevente unService = new ServiceOeuvrevente();
			unService.supprimerOeuvrevente(idOeuvrevente);

			destinationPage = "/Controleur?action=listerOeuvres";
		}

        else if (RESERVER_OEUVRE_VENTE.equals(actionName)) {
            int idOeuvrevente = Integer.parseInt(request.getParameter("idOeuvrevente"));
            int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
            ServiceOeuvrevente unService = new ServiceOeuvrevente();

            if(!unService.getOeuvrevente(idOeuvrevente).isReserved()){
                unService.reserverOeuvrevente(idOeuvrevente,idAdherent);
            }

            destinationPage = "/Controleur?action=listerOeuvres";
        }

        else if (LISTER_RESERVATIONS.equals(actionName)) {

            ServiceReservation unService = new ServiceReservation();
            request.setAttribute("mesReservations", unService.consulterListeReservations());

            destinationPage = "/listerReservations.jsp";
        }

		else {
			String messageErreur = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute(ERROR_KEY, messageErreur);
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}
