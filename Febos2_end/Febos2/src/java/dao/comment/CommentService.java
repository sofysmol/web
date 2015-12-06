/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.comment;

import dao.comment.*;
import java.util.ArrayList;
import java.util.List;
import dao.products.*;
import dao.shop.*;


/**
 *
 * @author SofySmo
 */
public class CommentService {
    private static CommentDao commentDao;
    public CommentService() {
        commentDao = new CommentDao();
    }
    public void persist(Comment entity) {
         try{
        commentDao.openCurrentSessionwithTransaction();
        commentDao.persist(entity);
        } finally {
        commentDao.closeCurrentSessionwithTransaction();
        }
    }
    public void update(Comment entity) {
        commentDao.openCurrentSessionwithTransaction();
        commentDao.update(entity);
        commentDao.closeCurrentSessionwithTransaction();
    }
    public Comment findById(Integer id) {
        commentDao.openCurrentSession();
        Comment comment = commentDao.findById(id);
        commentDao.closeCurrentSession();
        return comment;
    }
    public void delete(Integer id) {
        commentDao.openCurrentSessionwithTransaction();
        Comment comment = commentDao.findById(id);
        commentDao.delete(comment);
        commentDao.closeCurrentSessionwithTransaction();
    }
    public List<Comment> findAll() {
        commentDao.openCurrentSession();
        List<Comment> comments = commentDao.findAll();
        commentDao.closeCurrentSession();
        return comments;
    }
    public void deleteAll() {
        commentDao.openCurrentSessionwithTransaction();
         commentDao.deleteAll();
        commentDao.closeCurrentSessionwithTransaction();
    }
    public CommentDao commentDao() {
        return commentDao;
    }
    public List<Comment> findCommentByUserId(int id)
    {
        commentDao.openCurrentSession();
        List<Comment> comments=commentDao.findAllCommentByUserId(id);
        commentDao.closeCurrentSession();
        return comments;
    }
}


