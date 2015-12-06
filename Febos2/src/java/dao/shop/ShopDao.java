/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shop;

import dao.DaoInterface;
import dao.TDao;
import dao.shop.Shop;
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
public class ShopDao extends TDao<Shop,Integer> {
    public Shop findById(Integer id) {
      Shop shop = (Shop) getCurrentSession().get(Shop.class, id);
        return shop;
    }
    @SuppressWarnings("unchecked")
    public List<Shop> findAll() {
        List<Shop> users = (List<Shop>) getCurrentSession().createQuery("from Shop").list();
        return users;
    }
    public void deleteAll() {
        List<Shop> entityList = findAll();
        for (Shop entity : entityList) {
            delete(entity);
        }
    } 
 /*private Session currentSession;
    private Transaction currentTransaction;
    public ShopDao() {
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
    public void persist(Shop entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Shop entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Shop findById(Integer id) {
      Shop shop = (Shop) getCurrentSession().get(Shop.class, id);
        return shop;
    }
    @Override
    public void delete(Shop entity) {
        getCurrentSession().delete(entity);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> findAll() {
        List<Shop> books = (List<Shop>) getCurrentSession().createQuery("from Shop").list();
        return books;
    }
    @Override
    public void deleteAll() {
        List<Shop> entityList = findAll();
        for (Shop entity : entityList) {
            delete(entity);
        }
    }   */
}
