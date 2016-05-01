package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Reservation;
import com.epul.oeuvres.persistance.DialogueBd;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vil on 11/03/16.
 */
public class ServiceReservation {

    public List<Reservation> consulterListeReservations() throws MonException {
        String mysql = "select * from reservation;";
        //System.out.println(mysql);
        return consulterListeReservations(mysql);
    }

    private List<Reservation> consulterListeReservations(String mysql) throws MonException {
        List<Object> rs;
        List<Reservation> mesReservations = new ArrayList<Reservation>();
        ServiceOeuvrevente serveVente = new ServiceOeuvrevente();
        ServiceAdherent serveAdherent = new ServiceAdherent();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On crée un stage
                Reservation uneResa = new Reservation();
                // il faut redecouper la liste pour retrouver les lignes
                uneResa.setOeuvrevente(serveVente.getOeuvrevente(Integer.parseInt(rs.get(index + 0).toString())));
                uneResa.setAdherent(serveAdherent.getAdherent(Integer.parseInt(rs.get(index + 1).toString())));
                uneResa.setDate((Date)rs.get(index + 2));
                // On incrémente tous les 3 champs
                index = index + 4;
                mesReservations.add(uneResa);
            }

            return mesReservations;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }
}
