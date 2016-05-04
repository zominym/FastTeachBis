package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.entities.*;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by vil on 11/03/16.
 */
public class ServiceReservation extends EntityService {

    public List<Reservation> consulterListeReservations() throws MonException {{
        List<Reservation> mesReservations = null;
        try {
            EntityTransaction transac = startTransaction();
                transac.begin();
                mesReservations = (List<Reservation>)  entitymanager.createQuery("SELECT r FROM Reservation r").getResultList();
                entitymanager.close();
            }  catch (RuntimeException e){
                new MonException("Erreur de lecture ", e.getMessage());
            }
            return mesReservations;
        }
    }
}
