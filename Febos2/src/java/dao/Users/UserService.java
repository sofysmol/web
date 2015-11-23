/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Users;

import java.util.List;

/**
 *
 * @author SofySmo
 */
public class UserService {
    private static UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }
    public void persist(Users entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();
    }
    public void update(Users entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }
    public Users findById(Integer id) {
        userDao.openCurrentSession();
        Users user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }
    public void delete(Integer id) {
        userDao.openCurrentSessionwithTransaction();
        Users user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }
    public List<Users> findAll() {
        userDao.openCurrentSession();
        List<Users> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }
    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
         userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }
    public UserDao userDao() {
        return userDao;
    }
}


