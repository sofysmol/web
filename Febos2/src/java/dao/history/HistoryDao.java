/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.history;

import dao.DaoInterface;
import dao.TDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author SofySmo
 */
public class HistoryDao extends TDao<History,Integer>{
    public History findById(Integer id) {
      History book = (History) getCurrentSession().get(History.class, id);
        return book;
    }
    @SuppressWarnings("unchecked")
    public List<History> findAll() {
        List<History> users = (List<History>) getCurrentSession().createQuery("from History").list();
        return users;
    }
    public List<History> findAllHistoryByUserId(int id)
    {
        return (List<History>)getCurrentSession().createCriteria(History.class)
                .setMaxResults(100)
                .add(Restrictions.eq("userId", id)).list();
        
    }
    public void deleteAll() {
        List<History> entityList = findAll();
        for (History entity : entityList) {
            delete(entity);
        }
    } 
}
