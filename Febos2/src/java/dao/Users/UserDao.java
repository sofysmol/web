/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Users;

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
public class UserDao extends TDao<Users,Integer>{
    public UserDao() {
    }
    @SuppressWarnings("unchecked")
    public List<Users> findAll() {
        List<Users> users = (List<Users>) getCurrentSession().createQuery("from Users").list();
        return users;
    }
    public List<Users>  findByLogin(String login)
    {
       List<Users> users = 
            (List<Users>)getCurrentSession().createCriteria(Users.class)
                .setMaxResults(1)
                .add(Restrictions.eq("login", login)).list();
       return users;
    }
    public Users findById(Integer id) {
      Users user = (Users) getCurrentSession().get(Users.class, id);
        return user;
    }
    public void deleteAll() {
        List<Users> entityList = findAll();
        for (Users entity : entityList) {
            delete(entity);
        }
    } 
}
