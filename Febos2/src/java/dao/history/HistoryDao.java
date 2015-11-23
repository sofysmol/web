/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.history;

import dao.DaoInterface;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SofySmo
 */
public class HistoryDao implements DaoInterface<History, Integer> {
 private Session currentSession;
    private Transaction currentTransaction;
    public HistoryDao() {
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
        currentTransaction.commit();
        currentSession.close();
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
    public void persist(History entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(History entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public History findById(Integer id) {
      History book = (History) getCurrentSession().get(History.class, id);
        return book;
    }
    @Override
    public void delete(History entity) {
        getCurrentSession().delete(entity);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<History> findAll() {
        List<History> books = (List<History>) getCurrentSession().createQuery("from History").list();
        return books;
    }
    @Override
    public void deleteAll() {
        List<History> entityList = findAll();
        for (History entity : entityList) {
            delete(entity);
        }
    }   
}
