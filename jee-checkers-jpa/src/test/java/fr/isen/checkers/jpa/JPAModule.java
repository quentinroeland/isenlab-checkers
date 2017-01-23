package fr.isen.checkers.jpa;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.persistence.EntityManager;
import javax.transaction.*;

/**
 * Created by Quentin on 23/01/2017.
 */
public class JPAModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    public UserTransaction getUserTransaction(final EntityManager em){
        return new UserTransaction() {
            @Override
            public void begin() throws NotSupportedException, SystemException {

            }

            @Override
            public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {

            }

            @Override
            public void rollback() throws IllegalStateException, SecurityException, SystemException {

            }

            @Override
            public void setRollbackOnly() throws IllegalStateException, SystemException {

            }

            @Override
            public int getStatus() throws SystemException {
                return 0;
            }

            @Override
            public void setTransactionTimeout(int seconds) throws SystemException {

            }
        };
    }
}
