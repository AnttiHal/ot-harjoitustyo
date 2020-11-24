
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

import sointuvisa.dao.userDao;
import sointuvisa.dao.questionDao;
import sointuvisa.dao.userDao;

/**
 *
 * @author anttihalmetoja
 * Sovelluslogiikasta vastaava luokka 
 */
public class SointuvisaService {
    private questionDao questionDao;
    private userDao userDao;
    private User user;

    public SointuvisaService(questionDao questionDao, userDao userDao) {
        this.questionDao = questionDao;
        this.userDao = userDao;
    }
    
    /**
    * kirjautuneena oleva käyttäjä
    * 
    * @return kirjautuneena oleva käyttäjä 
    */   
    
    public User getUser() {
        return user;
    }
    
    public Boolean createUser(String username) {
        
        User user= new User(username);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public Question getQuestionById (int id) throws Exception {        
        Question q= questionDao.findQuestionById(id);        
        return q;
    }
    
    public User getUserByUsername (String name) throws Exception{
        User u = userDao.findUserByName(name);
        return u;
    }
    
    
    
}
