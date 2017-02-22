package fr.isen.checkers.web;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Quentin on 22/02/2017.
 */
public class EntityManagerProducer {
    @SuppressWarnings("unused")
    @PersistenceContext(name="db-manager")
    EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }
}
