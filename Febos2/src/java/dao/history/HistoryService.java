/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.history;

import java.util.List;

/**
 *
 * @author SofySmo
 */
public class HistoryService {
    private static HistoryDao historyDao;
    public HistoryService() {
        historyDao = new HistoryDao();
    }
    public void persist(History entity) {
        historyDao.openCurrentSessionwithTransaction();
        historyDao.persist(entity);
        historyDao.closeCurrentSessionwithTransaction();
    }
    public void update(History entity) {
        historyDao.openCurrentSessionwithTransaction();
        historyDao.update(entity);
        historyDao.closeCurrentSessionwithTransaction();
    }
    public History findById(Integer id) {
        historyDao.openCurrentSession();
        History history = historyDao.findById(id);
        historyDao.closeCurrentSession();
        return history;
    }
    public void delete(Integer id) {
        historyDao.openCurrentSessionwithTransaction();
        History history = historyDao.findById(id);
        historyDao.delete(history);
        historyDao.closeCurrentSessionwithTransaction();
    }
    public List<History> findAll() {
        historyDao.openCurrentSession();
        List<History> historys = historyDao.findAll();
        historyDao.closeCurrentSession();
        return historys;
    }
    public void deleteAll() {
        historyDao.openCurrentSessionwithTransaction();
         historyDao.deleteAll();
        historyDao.closeCurrentSessionwithTransaction();
    }
    public HistoryDao historyDao() {
        return historyDao;
    }
}


