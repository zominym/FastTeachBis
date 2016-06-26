package com.epul.oeuvres.dao;

import com.epul.oeuvres.entities.Result;
import com.epul.oeuvres.entities.Game;
import com.epul.oeuvres.entities.User;
import com.epul.oeuvres.meserreurs.MonException;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RegistrationService extends EntityService {

    public void insertRegistration(Registration registration) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(registration);
            entitymanager.flush();
            transac.commit();
            entitymanager.close();
        } catch (Exception e) {
            new MonException("Erreur d'insertion", e.getMessage());
        }
    }
}
