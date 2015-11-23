/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.products;

import java.util.List;

/**
 *
 * @author SofySmo
 */
public class ProductService {
    private static ProductDao productsDao;
    public ProductService() {
        productsDao = new ProductDao();
    }
    public void persist(Products entity) {
        productsDao.openCurrentSessionwithTransaction();
        productsDao.persist(entity);
        productsDao.closeCurrentSessionwithTransaction();
    }
    public void update(Products entity) {
        productsDao.openCurrentSessionwithTransaction();
        productsDao.update(entity);
        productsDao.closeCurrentSessionwithTransaction();
    }
    public Products findById(Integer id) {
        productsDao.openCurrentSession();
        Products products = productsDao.findById(id);
        productsDao.closeCurrentSession();
        return products;
    }
    public void delete(Integer id) {
        productsDao.openCurrentSessionwithTransaction();
        Products products = productsDao.findById(id);
        productsDao.delete(products);
        productsDao.closeCurrentSessionwithTransaction();
    }
    public List<Products> findAll() {
        productsDao.openCurrentSession();
        List<Products> productss = productsDao.findAll();
        productsDao.closeCurrentSession();
        return productss;
    }
    public void deleteAll() {
        productsDao.openCurrentSessionwithTransaction();
         productsDao.deleteAll();
        productsDao.closeCurrentSessionwithTransaction();
    }
    public ProductDao productsDao() {
        return productsDao;
    }
}


