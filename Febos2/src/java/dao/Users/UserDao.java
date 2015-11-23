/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Users;

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
public class UserDao implements DaoInterface<Users, Integer> {
 private Session currentSession;
    private Transaction currentTransaction;
    public UserDao() {
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
    public void persist(Users entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Users entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Users findById(Integer id) {
      Users book = (Users) getCurrentSession().get(Users.class, id);
        return book;
    }
    @Override
    public void delete(Users entity) {
        getCurrentSession().delete(entity);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Users> findAll() {
        List<Users> books = (List<Users>) getCurrentSession().createQuery("from Users").list();
        return books;
    }
    @Override
    public void deleteAll() {
        List<Users> entityList = findAll();
        for (Users entity : entityList) {
            delete(entity);
        }
    }   
}
