/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shop;

import java.util.List;

/**
 *
 * @author SofySmo
 */
public class ShopService {
    private static ShopDao shopDao;
    public ShopService() {
        shopDao = new ShopDao();
    }
    public void persist(Shop entity) {
        shopDao.openCurrentSessionwithTransaction();
        shopDao.persist(entity);
        shopDao.closeCurrentSessionwithTransaction();
    }
    public void update(Shop entity) {
        shopDao.openCurrentSessionwithTransaction();
        shopDao.update(entity);
        shopDao.closeCurrentSessionwithTransaction();
    }
    public Shop findById(Integer id) {
        shopDao.openCurrentSession();
        Shop shop = shopDao.findById(id);
        shopDao.closeCurrentSession();
        return shop;
    }
    public void delete(Integer id) {
        shopDao.openCurrentSessionwithTransaction();
        Shop shop = shopDao.findById(id);
        shopDao.delete(shop);
        shopDao.closeCurrentSessionwithTransaction();
    }
    public List<Shop> findAll() {
        shopDao.openCurrentSession();
        List<Shop> shops = shopDao.findAll();
        shopDao.closeCurrentSession();
        return shops;
    }
    public void deleteAll() {
        shopDao.openCurrentSessionwithTransaction();
         shopDao.deleteAll();
        shopDao.closeCurrentSessionwithTransaction();
    }
    public ShopDao shopDao() {
        return shopDao;
    }
}


