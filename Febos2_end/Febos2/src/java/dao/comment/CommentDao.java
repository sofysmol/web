/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.comment;

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
public class CommentDao extends TDao<Comment,Integer>{
    public Comment findById(Integer id) {
      Comment book = (Comment) getCurrentSession().get(Comment.class, id);
        return book;
    }
    @SuppressWarnings("unchecked")
    public List<Comment> findAll() {
        List<Comment> users = (List<Comment>) getCurrentSession().createQuery("from Comment").list();
        return users;
    }
    public List<Comment> findAllCommentByUserId(int id)
    {
        return (List<Comment>)getCurrentSession().createCriteria(Comment.class)
                .setMaxResults(100)
                .add(Restrictions.eq("iduser", id)).list();
        
    }
    public void deleteAll() {
        List<Comment> entityList = findAll();
        for (Comment entity : entityList) {
            delete(entity);
        }
    } 
}
