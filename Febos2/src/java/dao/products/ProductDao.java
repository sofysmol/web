/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.products;

import dao.DaoInterface;
import dao.TDao;
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
public class ProductDao extends TDao<Products ,Integer>{

    //@Override
    public Products findById(Integer id) {
      Products book = (Products) getCurrentSession().get(Products.class, id);
        return book;
    }
    
   // @Override
    @SuppressWarnings("unchecked")
    public List<Products> findAll() {
        List<Products> shops = (List<Products>) getCurrentSession().createQuery("from Products").list();
        return shops;
    }
    //@Override
    public void deleteAll() {
        List<Products> entityList = findAll();
        for (Products entity : entityList) {
            delete(entity);
        }
    }   
}
