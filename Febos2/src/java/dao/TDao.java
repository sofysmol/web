/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SofySmo
 * @param <T>
 * @param <Id>
 */
public class TDao<T, Id extends Serializable> implements DaoInterface<T, Id>{
    
    public  Session currentSession;
    public  Transaction currentTransaction;
    public TDao() {
    }
    public Session openCurrentSession() {
        
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
         currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }    

    public void closeCurrentSession() {
        currentSession.close();
    }
    public void closeCurrentSessionwithTransaction() {
        try{
        currentTransaction.commit();
        }catch(Exception e)
        {
            if(currentTransaction!=null) currentTransaction.rollback();
            throw e;
        }
        finally{
        currentSession.close();
        }  
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    public Session getCurrentSession() {
       return currentSession;
    }
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
     @Override
    public void persist(T entity) {
        getCurrentSession().save(entity);
    }
    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }
    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
}
