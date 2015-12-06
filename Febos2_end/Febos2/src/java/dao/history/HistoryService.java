/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.history;

import java.util.ArrayList;
import java.util.List;
import dao.products.*;
import dao.shop.*;


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
         try{
        historyDao.openCurrentSessionwithTransaction();
        historyDao.persist(entity);
        }catch(Exception e)
        {
             throw e;
        } finally {
        historyDao.closeCurrentSessionwithTransaction();
        }
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

    public List<List<String>> findAllOrderByUserId(int id)
    {
        List<List<String>> answer=new ArrayList<List<String>>();
        historyDao.openCurrentSession();
        List<History> history=historyDao.findAllHistoryByUserId(id);
        ProductService serPr=new ProductService();
        ShopService serSh=new ShopService();
        for(int i=0;i<history.size();i++)
        {
            History h=history.get(i);
            Products pr=serPr.findById(h.getProductId());
            Shop sh;
            if(h.getShopId()==0)
            {
                sh=new Shop();
                sh.setName("0");
            }else
            sh=serSh.findById(h.getShopId());
            List<String> order=new ArrayList<String>();
            order.add(Integer.toString(h.getId()));
            order.add(pr.getAuthor());
            order.add(pr.getName());
            order.add(sh.getName());
            order.add(h.getDatabuy().toString());
            order.add(pr.getPrice());
            answer.add(order);
        }
        historyDao.closeCurrentSession();
        return answer;
    }
}


