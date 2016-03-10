package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;

public class ServiceOeuvrevente {
    public List<Oeuvrevente> consulterListeOeuvreventes() throws MonException {
        String mysql = "select * from Oeuvrevente;";
        //System.out.println(mysql);
        return consulterListeOeuvreventes(mysql);
    }

    private List<Oeuvrevente> consulterListeOeuvreventes(String mysql) throws MonException {
        List<Object> rs;
        List<Oeuvrevente> mesOeuvreventes = new ArrayList<Oeuvrevente>();
        int index = 0;
        try {
            ServiceProprietaire SP = new ServiceProprietaire();
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On crée un stage
                Oeuvrevente uneOeuvre = new Oeuvrevente();
                // il faut redecouper la liste pour retrouver les lignes
                uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
                uneOeuvre.setTitreOeuvrevente(rs.get(index + 1).toString());
                uneOeuvre.setEtatOeuvrevente(rs.get(index + 2).toString());
                uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
                uneOeuvre.setProprietaire(SP.consulterProprietaire(rs.get(index + 4).toString()));
                // On incrémente tous les 3 champs
                index = index + 5;
                mesOeuvreventes.add(uneOeuvre);
            }

            return mesOeuvreventes;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

	public void insererOeuvrevente(Oeuvrevente uneOeuvrevente, int idAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();

		mysql = "insert into oeuvrevente (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)"
		+ "values ('"+ uneOeuvrevente.getTitreOeuvrevente() + "','"
		+ "L" + "','"
		+ uneOeuvrevente.getPrixOeuvrevente() + "','"
		+ idAdherent + "')";

		unDialogueBd.insertionBD(mysql);
		
	}

	public void supprimerOeuvrevente(int idOeuvrevente) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		
		mysql = "delete from oeuvrevente where id_oeuvrevente=" + idOeuvrevente;

		unDialogueBd.insertionBD(mysql);
		
	}
}
