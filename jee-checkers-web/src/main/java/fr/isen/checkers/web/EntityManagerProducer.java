package fr.isen.checkers.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;

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
